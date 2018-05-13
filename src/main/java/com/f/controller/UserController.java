package com.f.controller;

import com.f.pojo.Employee;
import com.f.services.DepartmentService;
import com.f.services.OaPositionService;
import com.f.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@RequestMapping(value = "/users")
@Controller
public class UserController extends ApplicationController {
    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @Autowired
    private OaPositionService oaPositionService;

    @Autowired
    private DepartmentService departmentService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(value = "/")
    public void rootIndex(HttpServletResponse response) throws IOException {
        System.out.println("catch me");
        response.sendRedirect("/users/index");
    }

    @RequestMapping(value = "/register")
    public String register(@ModelAttribute("user") Employee user, Model model) {
        model.addAttribute("oaList", oaPositionService.getPositionList());
        model.addAttribute("departmentList", departmentService.getDepartmentList());
        return "/users/register";
    }

    @RequestMapping(value = "/doRegister", method = {RequestMethod.POST})
    public String doRegister(@ModelAttribute("user") Employee user, Model model) {
        try {
            if (userService.saveUser(user)) {
                model.addAttribute("message", "register success");
            } else {
                model.addAttribute("message", "false");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "/users/index";
    }
}
