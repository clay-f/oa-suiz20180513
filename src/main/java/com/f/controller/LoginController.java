package com.f.controller;

import com.f.core.common.Constants;
import com.f.core.common.ResponseJsonResult;
import com.f.core.exceptions.NotFoundException;
import com.f.services.UserService;
import org.apache.ibatis.javassist.tools.web.BadHttpRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@CrossOrigin
@Scope("prototype")
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    private Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private RedissonClient redissonClient;

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseJsonResult doLogin(@RequestBody Map<String, Object> map) {
        Subject currentUser = SecurityUtils.getSubject();
        String name = map.get("name").toString();
        String passwd = map.get("passwd").toString();
        if (!currentUser.isAuthenticated()) {
            String md5Passwd = new Sha256Hash(name, passwd).toHex();
            UsernamePasswordToken token = new UsernamePasswordToken(name, md5Passwd);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                RMapCache<String, Object> rMapCache = redissonClient.getMapCache(Constants.USER_CACHE_NAME);
                rMapCache.put(Constants.CURRENT_USER, currentUser.getPrincipal(), (long) 30, TimeUnit.MINUTES);
                logger.info("user: " + currentUser.getPrincipal() + " logged in successfully.");
                return ResponseJsonResult.successResponse("ok");
            } catch (UnknownAccountException uae) {
                uae.printStackTrace();
            } catch (IncorrectCredentialsException ice) {
                ice.printStackTrace();
            } catch (LockedAccountException lae) {
                lae.printStackTrace();
            }
        }
        throw new NotFoundException();
    }

    @PostMapping(value = "/register")
    public ResponseJsonResult doRegister(@RequestBody Map<String, String> params) {
        String sha2Passwd = new Sha256Hash(params.get("name"), params.get("passwd")).toHex();
        userService.save(params.get("name"), sha2Passwd, Integer.parseInt(params.get("oaPositionId")), Integer.parseInt(params.get("departmentId")));
        return ResponseJsonResult.successResponse("register success");
    }
}
