package com.f.services.impl;

import com.f.dao.EmployeeDao;
import com.f.dao.GenericMapper;
import com.f.pojo.Employee;
import com.f.services.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Scope("prototype")
@Service(value = "userService")
public class UserServiceImpl extends AbstractGenericService<Employee, Integer> implements UserService {
    @Autowired
    public UserServiceImpl(@Qualifier("employeeDao") GenericMapper mapper) {
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

    @Override
    public void save(Employee employee) {
        String passwd = new Md5Hash(employee.getPasswd(), employee.getName()).toHex();
        employee.setPasswd(passwd);
        super.save(employee);
    }
}
