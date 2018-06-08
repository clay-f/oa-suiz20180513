package com.f.controller;


import com.f.services.impl.GenericCrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ApplicationController {
    private GenericCrudService genericCrudService;

    public ApplicationController(GenericCrudService genericCrudService) {
        this.genericCrudService = genericCrudService;
    }

    public boolean authenticationUserLogin(HttpServletRequest request, HttpServletResponse response) {
        return false;
    }

    protected GenericCrudService getGenericService() {
        return this.genericCrudService;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List getAll() {
        return genericCrudService.getAll();
    }
}
