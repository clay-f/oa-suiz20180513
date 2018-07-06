package com.f.services;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable> {
    void save(T o);

    <T> List<T> getAll();

    <T> T get(ID id);

    void delete(ID id);

    void update(T t);

    Integer size();
}
