package com.akoca.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLoggingAspect {
    @Before("com.akoca.aspect.AopExpressions.excludeSetAndGet() ")
    public void beforeAdvice() {
        System.out.println("@Before advice Cloud for All dao methods");
    }
}
