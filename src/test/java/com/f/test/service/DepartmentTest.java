package com.f.test.service;

import com.f.services.DepartmentService;
import com.f.test.TestHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DepartmentTest {
    private DepartmentService departmentService = (DepartmentService) TestHelper.getInstance().getBean("departmentServiceImpl");
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getDepartmentList() {
        assert departmentService.getAll().size() > 0;
    }
}
