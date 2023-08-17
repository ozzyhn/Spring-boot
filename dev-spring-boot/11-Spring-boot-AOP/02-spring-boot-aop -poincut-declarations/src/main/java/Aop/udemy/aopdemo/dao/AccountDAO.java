package Aop.udemy.aopdemo.dao;

import Aop.udemy.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    // add a new method: findAccount()

    List<Account> findAccounts();

    void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);


    List<Account> findAccounts(boolean tripWire);
}
