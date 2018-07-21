package com.f.services;

import com.f.core.common.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericService<T, ID extends Serializable> {
    void save(T o);

    <T> List<T> getAll();

    <T> T get(ID id);

    void delete(ID id);

    void update(T t);

    Integer size();

    Page<T> findOnPage(Map<String, Object> params);
}
