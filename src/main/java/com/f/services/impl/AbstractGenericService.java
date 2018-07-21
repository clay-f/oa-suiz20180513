package com.f.services.impl;

import com.f.core.common.Constants;
import com.f.core.common.Page;
import com.f.dao.GenericDao;
import com.f.services.GenericService;
import com.google.common.collect.Maps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public abstract class AbstractGenericService<T, ID extends Serializable> implements GenericService<T, ID>, Serializable {
    protected static final Logger logger = LogManager.getLogger();
    private static final long serialVersionUID = 1L;

    protected GenericDao mapper;
    @Autowired
    private RedissonClient redissonClient;

    public AbstractGenericService(GenericDao mapper) {
        this.mapper = mapper;
    }

    public void setMapper(GenericDao mapper) {
        this.mapper = mapper;
    }

    public RedissonClient getRedissonClient() {
        return redissonClient;
    }

    public void setRedissonClient(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Transactional(readOnly = true)
    public <T> List<T> getAll() {
        String listName = this.getClass().getSimpleName().toLowerCase() + "_list";
        RMapCache<String, Object> rMapCache = redissonClient.getMapCache(Constants.RMAP_CACHE_NAME);
        rMapCache.expireAt(Instant.now().toEpochMilli() + 100000);
        List<T> list = (List<T>) rMapCache.get(listName);
        if (list == null) {
            rMapCache.put(listName, mapper.getAll(Maps.newHashMap()));
            list = (List<T>) rMapCache.get(listName);
        }
        return list;
    }

    @Transactional
    @Override
    public Page<T> findOnPage(Map<String, Object> params) {
        Page page = new Page();
        page.setCountSize(mapper.size());
        page.setResult(mapper.getAll(params));
        return page;
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
