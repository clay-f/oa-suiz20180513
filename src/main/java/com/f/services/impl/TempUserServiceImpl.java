package com.f.services.impl;

import com.f.dao.GenericCrudMapper;
import com.f.pojo.Employee;
import com.f.services.GenericCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("tuserService")
public class TempUserServiceImpl extends GenericCrudService<Employee, Integer> {
    @Autowired
    public TempUserServiceImpl(@Qualifier(value = "userDao") GenericCrudMapper mapper) {
        super(mapper);
    }
}
