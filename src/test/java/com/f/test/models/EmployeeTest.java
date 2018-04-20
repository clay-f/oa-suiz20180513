package com.f.test.models;

import com.f.dao.EmployeeDao;
import com.f.test.TestHelper;
import org.junit.Test;

public class EmployeeTest {
    private TestHelper testHelper = TestHelper.getInstance();

    @Test
    public void getEmployeeList() {
        assert testHelper != null;
       EmployeeDao employeeDao = (EmployeeDao) testHelper.getBean("employeeDao");
        assert employeeDao.getAllEmployee().size() > 0;
    }
}
