package com.f.controller;

import com.f.core.common.JResult;
import com.f.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@CrossOrigin
@Scope("prototype")
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    private Logger logger = LogManager.getLogger(getClass());

    @PostMapping(value = "/login", consumes = "application/json")
    public JResult doLogin(HttpServletRequest request, @RequestBody Map<String, Object> map) {
        Subject currentUser = SecurityUtils.getSubject();
        String name = map.get("name").toString();
        String passwd = map.get("passwd").toString();
        if (!currentUser.isAuthenticated()) {
            String md5Passwd = new Sha256Hash(name, passwd).toHex();
            UsernamePasswordToken token = new UsernamePasswordToken(name, md5Passwd);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                logger.info("user: " + currentUser.getPrincipal() + " logged in successfully.");
                return JResult.success("ok");
            } catch (UnknownAccountException uae) {
                uae.printStackTrace();
            } catch (IncorrectCredentialsException ice) {
                ice.printStackTrace();
            } catch (LockedAccountException lae) {
                lae.printStackTrace();
            }
        }
        return JResult.unauthorized();
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public JResult doRegister(@RequestBody Map<String, String> params) {
        String sha2Passwd = new Sha256Hash(params.get("name"), params.get("passwd")).toHex();
        userService.save(params.get("name"), sha2Passwd, Integer.parseInt(params.get("oaPositionId")), Integer.parseInt(params.get("departmentId")));
        return JResult.success("login success");
    }
}
