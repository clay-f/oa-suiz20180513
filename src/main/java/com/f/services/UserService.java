package com.f.services;

import com.f.pojo.Employee;

import java.util.Map;

public interface UserService extends GenericService<Employee, Integer> {
    Employee login(Map<String, Object> map) throws IllegalAccessException;

    boolean getUserByName(Map<String, Object> map);
}
