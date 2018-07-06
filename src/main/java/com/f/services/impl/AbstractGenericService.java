package com.f.services.impl;

import com.f.dao.GenericMapper;
import com.f.helper.RedisHelper;
import com.f.services.GenericService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public abstract class AbstractGenericService<T, ID extends Serializable> implements GenericService<T, ID>, Serializable {
    protected static final Logger logger = LogManager.getLogger();
    private static final long serialVersionUID = 1L;

    protected GenericMapper mapper;
    @Autowired
    private RedissonClient redissonClient;

    public AbstractGenericService(GenericMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public <T> List<T> getAll() {
        String listName = this.getClass().getSimpleName().toLowerCase() + "_list";
        RMap<String, Object> rMap = RedisHelper.getRMap(redissonClient, "mapMap");
        rMap.expireAt(Instant.now().toEpochMilli() + 6000);
        List<T> list = (List<T>) rMap.get(listName);
        if (list == null) {
            rMap.put(listName, mapper.getAll());
            list = (List<T>) rMap.get(listName);
        }
        return list;
    }

    @Transactional
    public Integer size() {
       return mapper.size();
    }
    @Transactional
    public void save(T t) {
        mapper.insert(t);
    }

    @Transactional
    public <T> T get(ID id) {
        return (T) mapper.get(id);
    }

    @Transactional
    public void delete(ID id) {
        mapper.delete(id);
    }

    @Transactional
    public void update(T t) {
        mapper.update(t);
    }
}
