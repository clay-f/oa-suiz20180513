package com.f.test.models;

import com.f.pojo.Employee;
import com.f.services.UserService;
import com.f.test.TestHelper;
import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
        assertFalse(userService.login(map).size() > 0);
    }

    @Test
    public void addEmployee() {
        String foo = Objects.toString(System.currentTimeMillis(), "error");
        Employee e = new Employee("t" + foo.substring(0, 9), "123456");
        e.setDepartmentId(1);
        e.setOaPositionId(1);
        assert userService.saveUser(e);
    }
}
