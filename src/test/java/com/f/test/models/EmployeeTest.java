package com.f.test.models;

import com.f.helper.OutputJsonHelper;
import com.f.pojo.Employee;
import com.f.services.UserService;
import com.f.test.TestHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EmployeeTest {
    private TestHelper testHelper = TestHelper.getInstance();
    private UserService userService = (UserService) testHelper.getBean("userService");
    private OutputJsonHelper outputJsonHelper = OutputJsonHelper.getJsonOutputInstance();

    @Test
    public void getEmployeeList() {
        assert testHelper != null;
    }

    @Test
    public void testLogin() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "foo");
        map.put("passwd", "123456");
        System.out.println( outputJsonHelper.outputJsonVal(userService.login(map).get(0)));
    }

    @Test
    public void addEmployee() {
        List<Employee> list = userService.getAllUsers();
        System.out.println(list);
    }
}
