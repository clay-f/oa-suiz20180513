package com.f.services.impl;

import com.f.dao.EmployeeDao;
import com.f.dao.GenericCrudMapper;
import com.f.pojo.Employee;
import com.f.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserServiceImpl extends GenericCrudService<Employee, Integer> implements UserService {
    @Autowired
    public UserServiceImpl(@Qualifier("employeeDao") GenericCrudMapper mapper) {
        super(mapper);
        userDao = (EmployeeDao) mapper;
    }

    private EmployeeDao userDao;

    @Transactional(readOnly = true)
    @Override
    public Employee login(Map<String, Object> map) throws IllegalAccessException {
        String tmpPasswd = (String) map.get("passwd");
        map.remove("passwd");
        Employee employee = userDao.getUserByCondition(map).get(0);
        if (BCrypt.checkpw(tmpPasswd, employee.getPasswd())) {
            return employee;
        } else {
            throw new IllegalAccessException("username or password error");
        }
    }


    @Transactional(readOnly = true)
    @Override
    public boolean getUserByName(Map<String, Object> map) {
        return userDao.getUserByCondition(map).size() > 0;
    }

    @Override
    public void save(Employee employee) {
        String passwd = BCrypt.hashpw(employee.getPasswd(), BCrypt.gensalt());
        employee.setPasswd(passwd);
        super.save(employee);
    }
}
