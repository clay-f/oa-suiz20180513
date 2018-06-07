package com.f.controller;

import com.f.services.impl.GenericCrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class BaseController<T> {
    private GenericCrudService genericCrudService;

    public BaseController(GenericCrudService genericCrudService) {
        this.genericCrudService = genericCrudService;
    }



}
