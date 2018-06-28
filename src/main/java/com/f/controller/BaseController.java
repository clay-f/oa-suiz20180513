package com.f.controller;

import com.f.common.JResult;
import com.f.pojo.Employee;
import com.f.pojo.Voucher;
import com.f.services.impl.AbstractGenericService;
import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

public abstract class BaseController<T, ID extends Serializable> {
    private AbstractGenericService abstractGenericService;
    @Resource
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

    @GetMapping("/report")
    public void report() {

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

    protected Integer getUserId() {
        Subject subject = SecurityUtils.getSubject();
        Voucher user = (Voucher) subject.getPrincipal();
        assert user != null;
        return user.getId();
    }
}
