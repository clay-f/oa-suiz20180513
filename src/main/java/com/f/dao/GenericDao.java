package com.f.dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<T, ID extends Serializable> {
    <T> T get(@Param("id") ID id);

    <K, V> List<Map<T, V>> getAll(Map<String, Object> params);

    int insert(T o);

    void update(T o);

    void delete(ID id);

    Integer size();
}
