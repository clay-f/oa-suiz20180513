package com.f.api;

import com.f.controller.AbstractController;
import com.f.core.pojo.Employee;
import com.f.services.impl.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@Scope("prototype")
@RestController
@RequestMapping(value = "/api/users")
public class UserController extends AbstractController<Employee, Integer> {
    @Autowired
    public UserController(@Qualifier("userService") AbstractGenericService abstractGenericService) {
        super(abstractGenericService);
    }
}
