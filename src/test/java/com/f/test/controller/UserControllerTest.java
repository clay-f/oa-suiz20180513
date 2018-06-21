package com.f.test.controller;

import com.f.api.controller.LoginController;
import com.f.api.controller.UserController;
import com.f.helper.OutputJsonHelper;
import com.f.pojo.Employee;
import com.f.services.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserControllerTest {
    OutputJsonHelper objectMapper = OutputJsonHelper.getJsonOutputInstance();

    @Autowired
    @Qualifier(value = "userController")
    private UserController userController;

    @Autowired
    @Qualifier(value = "loginController")
    private LoginController loginController;

    private MockMvc mockMvc;

    private InternalResourceViewResolver viewResolver;
    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @BeforeAll
    void setMockMvc() {
        viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).setViewResolvers(viewResolver).build();
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
    void getAllUsers() {
        try {
            Employee employee = new Employee("foo", "123456");
            mockMvc.perform(MockMvcRequestBuilders.post("/api/users/login").requestAttr("user", employee))
                    .andExpect(status().isOk())
                    .andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
