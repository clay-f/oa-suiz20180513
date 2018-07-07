package com.f.test.service;

import com.f.core.common.ResponseJsonResult;
import com.f.core.pojo.Employee;
import com.f.services.GenericService;
import com.f.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringJUnitWebConfig(locations = {"classpath:applicationContext.xml"})
public class EmployeeTest {
    @Mock
    private GenericService genericService;

    @Mock
    private UserService userService;

    @BeforeAll
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getEmployeeById() {
        Employee employee = new Employee(1, "foo", "123456");
        when(genericService.get(1)).thenReturn(ResponseJsonResult.successResponse(employee));
        genericService.get(1);
        verify(genericService, times(1)).get(1);
    }


    @Test
    public void testLogin() throws JsonProcessingException, IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "foo");
        map.put("passwd", "123456");
        when(userService.login(map)).thenReturn(new Employee(1, "foo", "123456"));
        assert userService.login(map).getName().equals("foo");
        verify(userService, times(1)).login(map);
    }
}
