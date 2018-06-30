package com.f.test.controller;

import com.f.controller.LoginController;
import com.f.api.UserController;
import com.f.helper.OutputJsonHelper;
import com.f.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.Instant;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc-servlet.xml"})
public class LoginTest {
    OutputJsonHelper objectMapper = OutputJsonHelper.getJsonOutputInstance();

    @Autowired
    @Qualifier(value = "userController")
    private UserController userController;

    @Autowired
    @Qualifier(value = "loginController")
    private LoginController loginController;

    private MockMvc mockMvc;

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @BeforeAll
    void setMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @DisplayName("test required obj shouldn't be null")
    @Test
    void requiredObjectShouldNotBeNull() {
        Assertions.assertNotNull(userService);
        Assertions.assertNotNull(userController);
        assert mockMvc != null;
    }

    @DisplayName("test user login")
    @Test
    void testLogin() {
        try {
            Map<String, String> map = Maps.newHashMap();
            map.put("name", "foo");
            map.put("passwd", "123456");
            String json = new ObjectMapper().writeValueAsString(map);
            mockMvc.perform(MockMvcRequestBuilders.post("/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                    .andExpect(status().isOk())
                    .andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testRegister() throws Exception {
        Map<String, String> map = Maps.newHashMap();
        map.put("name", Instant.now().toString().substring(18));
        map.put("passwd", "123456");
        map.put("departmentId", "1");
        map.put("oaPositionId", "1");
        String json = new ObjectMapper().writeValueAsString(map);
        mockMvc.perform(MockMvcRequestBuilders.post("/register").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
    }

}
