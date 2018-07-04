package com.f.core.security;

import com.f.helper.SpringContextHolder;
import com.f.core.pojo.Employee;
import com.f.services.UserService;
import com.google.common.collect.Maps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Map;

public class MyRealm extends AuthorizingRealm {
    private Logger logger = LogManager.getLogger(getClass());
    private String serviceBeanName;

    private UserService userService;

    public MyRealm() {
    }

    public MyRealm(String serviceBeanName) {
        this.serviceBeanName = serviceBeanName;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        Map<String, Object> map = Maps.newHashMap();
        String name = upToken.getUsername();
        map.put("name", name);
        Employee user = null;
        try {
            user = getUserService().login(map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (user != null) {
            return new SimpleAuthenticationInfo(user, user.getPasswd(), getName());
        }
        return null;
    }

    public String getServiceBeanName() {
        return serviceBeanName;
    }

    public void setServiceBeanName(String serviceBeanName) {
        this.serviceBeanName = serviceBeanName;
    }

    private UserService getUserService() {
        if (userService == null) {
            userService = SpringContextHolder.getBean(serviceBeanName);
        }
        return userService;
    }
}
