package com.f.controller;

import com.f.pojo.Employee;
import com.f.services.DepartmentService;
import com.f.services.OaPositionService;
import com.f.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@CrossOrigin
@RequestMapping(value = "/users")
@Controller
public class UserController {
    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @Autowired
    private OaPositionService oaPositionService;

    @Autowired
    private DepartmentService departmentService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/register")
    public String register(@ModelAttribute("user") Employee user, Model model) {
        model.addAttribute("oaList", oaPositionService.getPositionList());
        model.addAttribute("departmentList", departmentService.getDepartmentList());
        return "/users/register";
    }

    @RequestMapping(value = "/doRegister", method = {RequestMethod.POST})
    public String doRegister(@ModelAttribute("user") Employee user) {
        try {
            userService.saveUser(user);
            System.out.println("register success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @RequestMapping("/info")
    public String userInfo(@SessionAttribute("user") Employee user) {
        System.out.println("name: " + user.getName());
        return "/users/show";
    }

}
