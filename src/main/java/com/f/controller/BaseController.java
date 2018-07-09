package com.f.controller;

import com.f.core.common.Constants;
import com.f.core.common.ResponseJsonResult;
import com.f.core.pojo.Employee;
import com.f.core.pojo.Voucher;
import com.f.services.impl.AbstractGenericService;
import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/{id}")
    public ResponseJsonResult get(@PathVariable("id") ID id) {
        return ResponseJsonResult.successResponse(abstractGenericService.get(id));
    }

    @GetMapping(value = {"/list", "/index"})
    public ResponseJsonResult getAll() {
        return ResponseJsonResult.successResponse(abstractGenericService.getAll());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseJsonResult delete(@PathVariable("id") ID id) {
        abstractGenericService.delete(id);
        return ResponseJsonResult.successResponse("ok");
    }

    @GetMapping("/report")
    public void report() {

    }

    public AbstractGenericService getAbstractGenericService() {
        return abstractGenericService;
    }

    public void setAbstractGenericService(AbstractGenericService abstractGenericService) {
        this.abstractGenericService = abstractGenericService;
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

    public RedissonClient getRedissonClient() {
        return redissonClient;
    }

    protected Employee getUser() {
        RMapCache<String, Object> rMapCache = redissonClient.getMapCache(Constants.USER_CACHE_NAME);
        Employee user = (Employee) rMapCache.get(Constants.CURRENT_USER);
        if (user != null) {
            return user;
        }
        throw new NullPointerException("please do login before operate");
    }
}
