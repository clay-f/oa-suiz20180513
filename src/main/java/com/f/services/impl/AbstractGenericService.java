package com.f.services.impl;

import com.f.dao.GenericMapper;
import com.f.helper.RedisHelper;
import com.f.pojo.Employee;
import com.f.services.GenericService;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractGenericService<T, ID extends Serializable> implements GenericService<T, ID> {
    protected GenericMapper mapper;
    @Autowired
    private RedissonClient redissonClient;

    public AbstractGenericService(GenericMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public <T> List<T> getAll() {
        RMap<String, Object> rMap = RedisHelper.getRMap(redissonClient, "mapMap");
        List<T> list = (List<T>) rMap.get("list");
        if (list == null) {
            list = mapper.getAll();
            list = (List<T>) rMap.get("list");
        }
        return list;
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
