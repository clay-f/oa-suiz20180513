package com.f.lib;

import com.f.pojo.Employee;

import javax.servlet.http.HttpServletRequest;

public class UserAuthenticate {
    public static boolean validateUserLogin(HttpServletRequest request) {
        try {
            Employee user = (Employee) request.getSession().getAttribute("currentUser");
            if ( user != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
