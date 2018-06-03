package com.f.services;

import com.f.dao.GenericCrudMapper;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

public abstract class GenericCrudService<T, ID extends Serializable> {
    protected GenericCrudMapper mapper;

    public GenericCrudService(GenericCrudMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional
    public int insert(T t) {
        return mapper.insert(t);
    }
}
