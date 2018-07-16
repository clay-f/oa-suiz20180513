package com.f.test.controller;

import com.f.controller.LoginController;
import com.f.api.UserController;
import com.f.core.common.ResponseJsonResult;
import com.f.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.Instant;
import java.util.Map;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringJUnitWebConfig(locations = {"classpath:applicationContext.xml" })
public class LoginTest {
    @Mock
    private UserController userController;

    @Mock
    private LoginController loginController;

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @BeforeAll
    void setMockMvc() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    void testUserLogin() throws Exception {
            Map<String, Object> map = Maps.newHashMap();
            map.put("name", "foo");
            map.put("passwd", "123456");
            when(loginController.doLogin(map)).thenReturn(ResponseJsonResult.successResponse("ok"));
            String json = new ObjectMapper().writeValueAsString(map);
            mockMvc.perform(MockMvcRequestBuilders.post("/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.status.code", is(200)));
            verify(loginController, times(1)).doLogin(map);
            verifyNoMoreInteractions(loginController);
    }

    @Test
    void testRegister() throws Exception {
        Map<String, String> map = Maps.newHashMap();
        map.put("name", Instant.now().toString().substring(18));
        map.put("passwd", "123456");
        map.put("departmentId", "1");
        map.put("oaPositionId", "1");
        when(loginController.doRegister(map)).thenReturn(ResponseJsonResult.successResponse("register success"));
        String json = new ObjectMapper().writeValueAsString(map);
        mockMvc.perform(MockMvcRequestBuilders.post("/register").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        verify(loginController, times(1)).doRegister(map);
        verifyNoMoreInteractions(loginController);
    }

}
