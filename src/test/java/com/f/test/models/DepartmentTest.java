package com.f.test.models;

import com.f.dao.DepartmentDao;
import com.f.services.DepartMentService;
import com.f.test.TestHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class DepartmentTest {
    private DepartMentService departMentService = (DepartMentService) TestHelper.getInstance().getBean("departmentServiceImpl");
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getDepartmentList() {
        try {
            System.out.println(mapper.writeValueAsString(departMentService.getDepartmentList()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
