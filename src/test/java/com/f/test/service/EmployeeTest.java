package com.f.test.service;

import com.f.helper.OutputJsonHelper;
import com.f.services.UserService;
import com.f.test.TestHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmployeeTest {
    private TestHelper testHelper = TestHelper.getInstance();
    private UserService userService = (UserService) testHelper.getBean("userService");
    private OutputJsonHelper outputJsonHelper = OutputJsonHelper.getJsonOutputInstance();

    @Test
    public void getEmployeeById() {
        assert testHelper != null;
        assertNotNull(userService.get(16));
    }

    @Test
    public void testLogin() throws JsonProcessingException, IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "foo");
        map.put("passwd", "123456");
        assertNotNull(outputJsonHelper.outputJsonVal(userService.login(map)));
    }
}
