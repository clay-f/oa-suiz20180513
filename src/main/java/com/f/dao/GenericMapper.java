package com.f.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericMapper<T, ID extends Serializable> {
    <T> T get(ID id);

    <T> List<T> getAll();

    int insert(T o);

    void update(T o);

    void delete(ID id);

    Integer size();
}
