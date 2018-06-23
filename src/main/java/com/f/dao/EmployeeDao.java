package com.f.dao;

import com.f.pojo.Employee;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Map;

@Scope("prototype")
public interface EmployeeDao extends GenericMapper<Employee, Integer> {
    List<Employee> getUserByCondition(Map<String, Object> map);
}
