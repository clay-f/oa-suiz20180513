package com.f.services.impl;

import com.f.dao.GenericCrudMapper;
import com.f.pojo.Department;
import com.f.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends GenericCrudService<Department, Integer> implements DepartmentService {
    @Autowired
    public DepartmentServiceImpl(@Qualifier("departmentDao") GenericCrudMapper mapper) {
        super(mapper);
    }
}
