package com.f.dao;

import java.io.Serializable;

public interface GenericCrudMapper<T, ID extends Serializable> {
    Object fetchById(ID id);

    int insert(T t);
}
