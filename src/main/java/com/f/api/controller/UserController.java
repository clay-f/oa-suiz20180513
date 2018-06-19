package com.f.api.controller;

import com.f.pojo.Employee;
import com.f.services.impl.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/users")
public class UserController extends BaseController<Employee, Integer> {
    @Autowired
    public UserController(@Qualifier("userService") AbstractGenericService abstractGenericService) {
        super(abstractGenericService);
    }
}
