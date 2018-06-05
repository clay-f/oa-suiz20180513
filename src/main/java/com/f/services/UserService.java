package com.f.services;

import com.f.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface UserService extends GenericService<Employee, Integer> {
    List<Employee> login(Map<String, Object> map);

    boolean getUserByName(Map<String, Object> map);
}
