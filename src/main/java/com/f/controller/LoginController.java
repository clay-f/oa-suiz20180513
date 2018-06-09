package com.f.controller;

import com.f.pojo.Employee;
import com.f.services.DepartmentService;
import com.f.services.OaPositionService;
import com.f.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SessionAttributes("user")
@Controller
@RequestMapping("/users")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("oaPositionService")
    private OaPositionService oaPositionService;

    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute("user")
    public Employee setUpUserForm() {
        System.out.println("catch setup user form");
        return new Employee();
    }

    @GetMapping("/users")
    public void secondIndex(HttpServletResponse response) throws IOException {
        response.sendRedirect("/users/index");
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("user") Employee user) {
        return "/users/login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("user") Employee user, Model model, HttpServletRequest request) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", user.getName());
            map.put("passwd", user.getPasswd());
            Employee employee = userService.login(map);
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

    @RequestMapping(value = "/register")
    public String register(@ModelAttribute("user") Employee user, Model model) {
        model.addAttribute("oaList", oaPositionService.getAll());
        model.addAttribute("departmentList", departmentService.getAll());
        return "/users/register";
    }

    @RequestMapping(value = "/doRegister", method = {RequestMethod.POST})
    public String doRegister(@ModelAttribute("user") Employee user, Model model) {
        userService.save(user);
        return "redirect:/vouchers/index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, Model model) {
        request.getSession().removeAttribute("currentUser");
        return "redirect:/users/login";
    }
}
