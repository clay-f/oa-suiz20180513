package com.f.services.impl;

import com.f.dao.DepartmentDao;
import com.f.pojo.Department;
import com.f.services.DepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartMentService {
    @Autowired(required = true)
    private DepartmentDao departmentDao;

    @Transactional
    @Override
    public List<Department> getDepartmentList() {
        List<Department> departments = new ArrayList<Department>();
        try {
            departments = departmentDao.getAllDepartment();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }
}
