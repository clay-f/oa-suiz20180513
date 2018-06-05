package com.f.services.impl;

import com.f.dao.GenericCrudMapper;
import com.f.services.GenericService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class GenericCrudService<T, ID extends Serializable> implements GenericService<T, ID> {
    protected GenericCrudMapper mapper;

    public GenericCrudService(GenericCrudMapper mapper) {
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
