package com.akoca;

import com.akoca.config.DemoConfig;
import com.akoca.dao.AccountDao;
import com.akoca.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class DemoApp {

    private static Logger logger = Logger.getLogger(DemoApp.class.getName());
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = context.getBean("accountDao" , AccountDao.class);

        List<Account> accounts = null;

        try {
             accounts = accountDao.findAccounts(true);
        } catch (Exception e) {
            logger.info("Exception in main app is: " + e);
        }

        if(null != accounts) {
            for(Account acc : accounts) {
                logger.info(acc.toString());
            }
        }

        TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);

        String data = trafficFortuneService.getFortune();

        logger.info(data);

        context.close();
    }
}
