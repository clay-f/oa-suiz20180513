package com.f.controller;

import com.f.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public Employee setUpUserForm() {
        System.out.println("catch setup user form");
        return new Employee();
    }

    @GetMapping("/users/")
    public String index() {
        return "/users/index";
    }

    @GetMapping("/users")
    public String secondIndex() {
        return "/users/index";
    }

    @RequestMapping("/users/login")
    public String login(@ModelAttribute("user") Employee user) {
        return "/users/register";
    }

    @PostMapping("/users/doLogin")
    public String doLogin(@ModelAttribute("user") Employee user, Model model) {
        if (user.getName().equals("foo")) {
            user.setName("foo");
            return "redirect:/users/info";
        } else {
            model.addAttribute("message", "error");
            return "/users/register";
        }
    }
}
