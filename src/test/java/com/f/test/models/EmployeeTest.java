package com.f.test.models;

import com.f.pojo.Employee;
import com.f.services.UserService;
import com.f.test.TestHelper;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class EmployeeTest {
    private TestHelper testHelper = TestHelper.getInstance();
    UserService userService = (UserService) testHelper.getBean("userService");

    @Test
    public void getEmployeeList() {
        assert testHelper != null;
    }

    @Test
    public void testLogin() {
        Map<String, Object> map = new HashMap<String, Object>();
        assertFalse(userService.login(map));
    }

    @Test
    public void addEmployee() {
        Employee e = new Employee("foo", "123456");
        e.setDepartmentId(1);
        e.setOaPositionId(1);
        assert userService.saveUser(e);
    }
}
