package com.f.dao;

import com.f.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeDao {
    List<Employee> getAllEmployee();

    Integer getUserByCondition(Map<String, Object> map);

    void saveEmployee(Employee employee);
}
