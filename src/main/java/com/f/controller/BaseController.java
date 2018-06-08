package com.f.controller;

import com.f.services.impl.GenericCrudService;

import java.io.Serializable;

public class BaseController<T, ID extends Serializable> {
    private GenericCrudService genericCrudService;

    public BaseController(GenericCrudService genericCrudService) {
        this.genericCrudService = genericCrudService;
    }
}
