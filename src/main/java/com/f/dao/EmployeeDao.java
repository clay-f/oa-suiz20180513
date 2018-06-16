package com.f.dao;

import com.f.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDao extends GenericMapper<Employee, Integer> {
    List<Employee> getUserByCondition(Map<String, Object> map);
}
