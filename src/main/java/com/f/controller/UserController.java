package com.f.controller;

import com.f.pojo.Employee;
import com.f.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RequestMapping(value = "/users")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/register")
    public String register(@RequestParam Map<String, Object> map) {
        return "/users/register";
    }

    @RequestMapping("/info")
    public String userInfo(@SessionAttribute("user")Employee user) {
        System.out.println("name: " +user.getName());
        return "/users/show";
    }

}
