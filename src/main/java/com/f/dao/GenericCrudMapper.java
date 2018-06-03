package com.f.dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface GenericCrudMapper<T, ID extends Serializable> {
    Object fetchById(ID id);

    //List<T> fetch(@Param("searchCriteria") SearchCriteria searchCriteria); 封装一个查询累用来判断查询
    List<T> fetch(@Param("searchCriteria") String searchCriteria);

    int insert(T o);

    void update(T o);

    void delete(T o);
}
