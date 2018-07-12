package com.f.dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
    <T> T get(@Param("id") ID id);

    <T> List<T> getAll();

    int insert(T o);

    void update(T o);

    void delete(ID id);

    Integer size();
}
