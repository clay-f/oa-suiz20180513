package com.f.controller;

import com.f.common.JResult;
import com.f.pojo.Employee;
import com.f.services.DepartmentService;
import com.f.services.OaPositionService;
import com.f.services.impl.GenericCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class UserController extends BaseController<Employee, Integer> {
    @Autowired
    @Qualifier("oaPositionService")
    private OaPositionService oaPositionService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    public UserController(@Qualifier("userService") GenericCrudService genericCrudService) {
        super(genericCrudService);
    }

    @GetMapping(value = "/")
    public void rootIndex(HttpServletResponse response) throws IOException {
        response.sendRedirect("/users/index");
    }

    @RequestMapping(value = "/register")
    public JResult register(@ModelAttribute("user") Employee user, Model model) {
        model.addAttribute("oaList", oaPositionService.getAll());
        model.addAttribute("departmentList", departmentService.getAll());
        return JResult.success("ok");
    }

    @RequestMapping(value = "/doRegister", method = {RequestMethod.POST})
    public JResult doRegister(@ModelAttribute("user") Employee user, Model model) {
        getGenericCrudService().save(user);
        return JResult.success("ok");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public JResult logout(HttpServletRequest request, Model model) {
        request.getSession().removeAttribute("currentUser");
        return JResult.success("ok");
    }
}
