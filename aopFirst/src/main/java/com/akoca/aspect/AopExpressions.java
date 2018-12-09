package com.akoca.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.akoca.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.akoca.dao.*.get*(..))")
    public void forGetters() {}

    @Pointcut("execution(* com.akoca.dao.*.set*(..))")
    public void forSetters() {}

    @Pointcut("forDaoPackage() && !(forGetters() || forSetters())")
    public void excludeSetAndGet() {}

}
