package com.f.services.impl;

import com.f.dao.EmployeeDao;
import com.f.pojo.Employee;
import com.f.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired(required = true)
    @Qualifier(value = "employeeDao")
    private EmployeeDao userDao;

    @Transactional
    @Override
    public List<Employee> login(Map<String, Object> map) {
        List<Employee> employeeList = new ArrayList<Employee>();
        try {
            employeeList = userDao.getUserByCondition(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Transactional
    @Override
    public boolean saveUser(Employee employee) {
        try {
            userDao.saveEmployee(employee);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    @Override
    public boolean getUserByName(Map<String, Object> map) {
        try {
            return userDao.getUserByCondition(map).size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
