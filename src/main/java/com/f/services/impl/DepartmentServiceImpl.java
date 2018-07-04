package com.f.services.impl;

import com.f.dao.GenericMapper;
import com.f.core.pojo.Department;
import com.f.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends AbstractGenericService<Department, Integer> implements DepartmentService {
    @Autowired
    public DepartmentServiceImpl(@Qualifier("departmentDao") GenericMapper mapper) {
        super(mapper);
    }
}
