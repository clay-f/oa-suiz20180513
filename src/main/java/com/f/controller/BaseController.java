package com.f.controller;

import com.f.common.JResult;
import com.f.services.impl.AbstractGenericService;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

public abstract class BaseController<T, ID extends Serializable> {
    private AbstractGenericService abstractGenericService;
    @Autowired
    private HttpServletRequest request;

    public BaseController(AbstractGenericService abstractGenericService) {
        this.abstractGenericService = abstractGenericService;
    }

    @RequestMapping("/{id}")
    public JResult get(@PathVariable("id") ID id) {
        return JResult.success(abstractGenericService.get(id));
    }

    @RequestMapping("/list")
    public JResult getAll() {
        Map<String, Object> params = getRequestParams();
        return JResult.success(abstractGenericService.getAll());
    }

    @RequestMapping("/{id}/delete")
    public JResult delete(@PathVariable("id") ID id) {
        abstractGenericService.delete(id);
        return JResult.success("ok");
    }

    @RequestMapping("/index")
    public JResult index() {
        return JResult.success(abstractGenericService.getAll());
    }

    public AbstractGenericService getAbstractGenericService() {
        return abstractGenericService;
    }


    protected Map<String, Object> getRequestParams() {
        return getRequestParams(request);
    }

    private Map<String, Object> getRequestParams(HttpServletRequest request) {
        Iterator<String> iterator = request.getParameterMap().keySet().iterator();
        Map<String, Object> map = Maps.newHashMap();
        String key = "";
        while (iterator.hasNext()) {
            key = iterator.next();
            map.put(key, getRequestValByRequestParams(request, key));
        }
        return map;
    }

    private Object getRequestValByRequestParams(HttpServletRequest request, String key) {
        String[] vals = request.getParameterValues(key);
        Object obj = null;
        if (vals != null && vals.length == 1) {
            obj = vals[0];
        } else {
            obj = vals;
        }
        return obj;
    }


}
