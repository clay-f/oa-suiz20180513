package com.f.dao;

import com.f.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {
    List<Employee> getAllEmployee();
}
