package com.akoca.dao;

import com.akoca.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao {

    private String accountName;
    private String serviceCode;

    public void addAccount(Account account) {
        System.out.println(getClass() + "doing db work account is " + account);
    }

    public String getAccountName() {
        System.out.println(getClass() + " in getAccountName");
        return accountName;
    }

    public void setAccountName(String accountName) {
        System.out.println(getClass() + " in setAccountName");
        this.accountName = accountName;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " in getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {

        System.out.println(getClass() + " in setAccountName");
        this.serviceCode = serviceCode;
    }

    public List<Account> findAccounts(boolean b) throws Exception {
        List<Account> myAccounts = new ArrayList<>();

        myAccounts.add(new Account("acc1" , "silver"));
        myAccounts.add(new Account("acc2" , "platinum"));
        myAccounts.add(new Account("acc3" , "gold"));

        if(b) {
            throw new Exception();
        }

        return myAccounts;
    }
}
