package com.f.services;

import com.f.core.pojo.Employee;

import java.util.Map;

public interface UserService extends GenericService<Employee, Integer> {
    Employee login(Map<String, Object> map) throws IllegalAccessException;

    boolean getUserByName(Map<String, Object> map);

    void save(String name, String shaPasswd, Integer oaPositionId, Integer departmentId);

}
