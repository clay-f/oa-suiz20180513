package com.f.core.aspectj;

import com.f.helper.OutputJsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LogAOP {
    private static Logger logger = LogManager.getLogger(LogAOP.class);
    private Object proceed;

    @Pointcut("execution(* com.f.services.*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint jp) {
        logger.info("catch before method, method name: " + jp.getSignature() + "\t params: " + jp.getArgs());
    }

    @After("pointcut()")
    public void after(JoinPoint jp) {
        logger.info("catch after method, after invoked " + jp.getSignature() + " method");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object obj = null;
        obj = proceed;
        logger.info("around method catch val: " + OutputJsonHelper.outputJsonVal(obj));
        return obj;
    }
}
