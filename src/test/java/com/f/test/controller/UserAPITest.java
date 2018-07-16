package com.f.test.controller;

import com.f.api.UserController;
import com.f.core.common.ResponseJsonResult;
import com.f.core.pojo.Employee;
import com.f.services.GenericService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringJUnitWebConfig(locations = {"classpath:applicationContext.xml"})
public class UserAPITest {
    @Mock
    private UserController userController;
    private MockMvc mockMvc;

    @Mock
    private GenericService genericService;

    @BeforeAll
    void setMockMvc() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void getAllUser() throws Exception {
        List<Employee> list = Lists.newArrayList(new Employee(1, "foo", "123456"), new Employee(2, "bar", "123456"));
        when(userController.getAll()).thenReturn(ResponseJsonResult.successResponse(list));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/list"))
                .andExpect(status().isOk())
        .andExpect(jsonPath("$.result", hasSize(2)))
        .andExpect(jsonPath("$.result[0].id", is(1)))
        .andExpect(jsonPath("$.result[0].name", is("foo")));
        verify(userController, times(1)).getAll();
    }

    @Test
    void findOne() throws Exception {
        Employee employee = new Employee(1, "foo", "123456");
        when(userController.get(1)).thenReturn(ResponseJsonResult.successResponse(employee));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{id}", 1).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result.id", is(1)));
        verify(userController, times(1)).get(1);
    }


}
