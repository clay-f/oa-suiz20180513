package com.f.services.impl;

import com.f.dao.EmployeeDao;
import com.f.dao.GenericDao;
import com.f.core.pojo.Employee;
import com.f.services.UserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Scope("prototype")
@Service(value = "userService")
public class UserServiceImpl extends AbstractGenericService<Employee, Integer> implements UserService {
    @Autowired
    public UserServiceImpl(@Qualifier("employeeDao") GenericDao mapper) {
        super(mapper);
        userDao = (EmployeeDao) mapper;
    }

    private EmployeeDao userDao;

    @Transactional(readOnly = true)
    @Override
    public Employee login(Map<String, Object> map) throws IllegalAccessException {
        return userDao.getUserByCondition(map).get(0);
    }


    @Transactional(readOnly = true)
    @Override
    public boolean getUserByName(Map<String, Object> map) {
        return userDao.getUserByCondition(map).size() > 0;
    }

    @Transactional
    @Override
    public void save(String name, String passwd, Integer oaPositionId, Integer departmentId) {
        String shaPasswd = new Sha256Hash(passwd, name).toHex();
        userDao.save(name, passwd, oaPositionId, departmentId);
    }
}
