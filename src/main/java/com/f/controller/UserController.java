package com.f.controller;

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
    ObjectMapper objectMapper = new ObjectMapper();

    @ResponseBody
    @RequestMapping(value = "/login", produces = "text/plain;charset=utf-8", method = {RequestMethod.POST})
    public String login(@RequestParam Map<String, Object> map) {
        if (userService.login(map)) {
            return "";
        }
        return "/users/index";
    }
}
