package com.f.test.service;

import com.f.services.DepartmentService;
import com.f.test.TestHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class DepartmentTest {
    private DepartmentService departmentService = (DepartmentService) TestHelper.getInstance().getBean("departmentServiceImpl");
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getDepartmentList() {
        try {
            System.out.println(mapper.writeValueAsString(departmentService.getAll()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
