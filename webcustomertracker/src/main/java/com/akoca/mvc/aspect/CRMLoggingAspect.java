package com.akoca.mvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution (* com.akoca.mvc.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution (* com.akoca.mvc.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution (* com.akoca.mvc.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String methodSignature = joinPoint.getSignature().toShortString();

        logger.info("in before : calling : " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for(Object o : args) {
            logger.info("arg is : " + o.toString());
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()" ,
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint , Object result) {
        String methodSignature = joinPoint.getSignature().toShortString();
        logger.info("In after returning: " + methodSignature);

        logger.info("result: " + result);
    }
}
