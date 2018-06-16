package com.f.controller;

import com.f.common.JResult;
import com.f.pojo.Employee;
import com.f.services.DepartmentService;
import com.f.services.OaPositionService;
import com.f.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    private Logger logger = LogManager.getLogger(getClass());

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
    @ResponseBody
    public JResult doLogin(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "passwd", required = false) String passwd,
                           HttpServletRequest request) {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            String salt = request.getParameter("name");
            String md5Passwd = new Md5Hash(passwd, salt).toHex();
            UsernamePasswordToken token = new UsernamePasswordToken(name, md5Passwd);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                logger.info("user: " + currentUser.getPrincipal() + "logged in successfully.");
                return JResult.success("ok");
            } catch (UnknownAccountException uae) {
                uae.printStackTrace();
            } catch (IncorrectCredentialsException ice) {
                ice.printStackTrace();
            } catch (LockedAccountException lae) {
                lae.printStackTrace();
            }
        }
        return JResult.unauthorized();
    }

    @RequestMapping(value = "/register")
    public String register(@ModelAttribute("user") Employee user, Model model) {
        model.addAttribute("oaList", oaPositionService.getAll());
        model.addAttribute("departmentList", departmentService.getAll());
        return "/users/register";
    }

    @ResponseBody
    @RequestMapping(value = "/doRegister", method = {RequestMethod.POST})
    public JResult doRegister(@ModelAttribute("user") Employee user, Model model) {
        userService.save(user);
        return JResult.success("ok");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, Model model) {
        SecurityUtils.getSubject().logout();
        return "redirect:/users/login";
    }
}
