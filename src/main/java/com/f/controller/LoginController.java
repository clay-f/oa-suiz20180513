package com.f.controller;

import com.f.pojo.Employee;
import com.f.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("user")
public class LoginController {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public Employee setUpUserForm() {
        System.out.println("catch setup user form");
        return new Employee();
    }

    @GetMapping("/users")
    public void secondIndex(HttpServletResponse response) throws IOException {
        response.sendRedirect("/users/index");
    }

    @RequestMapping("/users/login")
    public String login(@ModelAttribute("user") Employee user) {
        return "/users/login";
    }

    @PostMapping("/users/doLogin")
    public String doLogin(@ModelAttribute("user") Employee user, Model model, HttpServletRequest request) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", user.getName());
            map.put("passwd", user.getPasswd());
            Employee employee = userService.login(map).get(0);
            if (employee != null) {
                user = employee;
                request.getSession().setAttribute("currentUser", user);
                model.addAttribute("message", "1");
            }
            return "redirect:/vouchers/index";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("message", "you haven't ont count, sign up to create account");
        return "redirect:/users/register";
    }
}
