package com.f.controller;

import com.f.pojo.Employee;
import com.f.services.DepartmentService;
import com.f.services.OaPositionService;
import com.f.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@RequestMapping(value = "/users")
@Controller("userController")
public class UserController extends ApplicationController {
    private Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @Autowired
    private OaPositionService oaPositionService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/")
    public void rootIndex(HttpServletResponse response) throws IOException {
        response.sendRedirect("/users/index");
    }

    @RequestMapping(value = "/register")
    public String register(@ModelAttribute("user") Employee user, Model model) {
        model.addAttribute("oaList", oaPositionService.getAll());
        model.addAttribute("departmentList", departmentService.getAll());
        return "/users/register";
    }

    @RequestMapping(value = "/doRegister", method = {RequestMethod.POST})
    public String doRegister(@ModelAttribute("user") Employee user, Model model) {
        userService.save(user);
        model.addAttribute("message", "register success");
        return "index";
    }

    @RequestMapping("/index")
    public String index(Model model, @SessionAttribute(name = "currentUser", required = false) Employee user) {
        logger.info("user index, login user val: " + user);
        model.addAttribute("userList", userService.getAll());
        return "/users/index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, Model model) {
        request.getSession().removeAttribute("currentUser");
        return "redirect:/users/login";
    }
}
