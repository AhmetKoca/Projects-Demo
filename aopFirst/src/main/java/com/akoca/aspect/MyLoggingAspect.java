package com.akoca.aspect;

import com.akoca.Account;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;


@Aspect
@Component
@Order(3)
public class MyLoggingAspect {
    
    private Logger logger = Logger.getLogger(MyLoggingAspect.class.getName());

    @Before("com.akoca.aspect.AopExpressions.excludeSetAndGet() ")
    public void beforeAdvice(JoinPoint jointPoint) {
        logger.info("@Before advice MyDemoLogging for All dao methods");
        MethodSignature methodSignature = (MethodSignature) jointPoint.getSignature();
        logger.info("Method is: " + methodSignature);

        Object[] args = jointPoint.getArgs();

        for(Object o : args) {
            logger.info(o.toString());

            if(o instanceof Account) {
                Account account = (Account)o;

                logger.info("Account name : " + account.getName());
                logger.info("Account: level" + account.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution (* com.akoca.dao.AccountDao.findAccounts(..))" ,
            returning = "result"
    )
    public void afterReturningAdvice(JoinPoint joinPoint , List<Account> result) {
        logger.info("After: " + joinPoint.getSignature().toShortString());

        logger.info("Result is: " + result);

        for(Account account : result) {
            account.setName(account.getName().toUpperCase());
        }

        logger.info("Uppercase Result is: " + result);
    }

    @AfterThrowing(
            pointcut = "execution (* com.akoca.dao.AccountDao.findAccounts(..))" ,
            throwing = "theException")
    public void afterExceptionAdvice(JoinPoint joinPoint , Throwable theException) {
        logger.info("Thrown exception is: " + theException);
    }

    @After(value = "execution (* com.akoca.dao.AccountDao.findAccounts(..)) && args(joinpoint)")
    public void afterAdvice(Joinpoint joinpoint) {
        logger.info("Afterrrrrrrr");
    }

    @Around("execution(* com.akoca.service.*.getFortune(..))")
    public Object afterGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();

        Object object = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        logger.info("Duration: ----->" + (end - begin));

        return object;
    }


}