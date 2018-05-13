package com.f.aspectj;

import com.f.interceptors.UserLoginInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class EmployeeAop {
    private static Logger logger = LogManager.getLogger(EmployeeAop.class);

    @Pointcut("execution(* com.f.services.*.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void before(JoinPoint jp) {
        logger.info("catch before method, method name: " + jp.getSignature() + "\t params: " +  jp.getArgs());
    }

    @After("pointcut()")
    public void after(JoinPoint jp) {
       logger.info("catch after method, after invoked " + jp.getSignature() + " method");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object obj = null;
        try {
            obj =  proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
}
