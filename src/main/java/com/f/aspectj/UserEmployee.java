package com.f.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserEmployee {
    @Pointcut("execution(* com.f.services.impl.*.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void before() {
        System.out.println("catch before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("catch after");
    }
}
