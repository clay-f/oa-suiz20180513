package com.f.services.impl;

import com.f.dao.GenericMapper;
import com.f.services.GenericService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractGenericService<T, ID extends Serializable> implements GenericService<T, ID> {
    protected GenericMapper mapper;

    public AbstractGenericService(GenericMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public <T> List<T> getAll() {
        return mapper.getAll();
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
