package com.f.controller;

import com.f.common.JResult;
import com.f.services.impl.GenericCrudService;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseController<T, ID extends Serializable> {
    private GenericCrudService genericCrudService;

    public BaseController(GenericCrudService genericCrudService) {
        this.genericCrudService = genericCrudService;
    }

    @RequestMapping("/{id}")
    public JResult get(@PathVariable("id") ID id) {
        return JResult.success(genericCrudService.get(id));
    }

    @RequestMapping("/list")
    public JResult getAll() {
        return JResult.success(genericCrudService.getAll());
    }

    @RequestMapping("/{id}/delete")
    public JResult delete(@PathVariable("id") ID id) {
        genericCrudService.delete(id);
        return JResult.success("ok");
    }

    @RequestMapping("/index")
    public JResult index() {
        return JResult.success(genericCrudService.getAll());
    }

    public GenericCrudService getGenericCrudService() {
        return genericCrudService;
    }
}
