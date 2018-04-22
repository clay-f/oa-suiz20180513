package com.f.services;

import com.f.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<Employee> login(Map<String, Object> map);

    boolean saveUser(Employee employee);

    boolean getUserByName(Map<String, Object> map);
}
