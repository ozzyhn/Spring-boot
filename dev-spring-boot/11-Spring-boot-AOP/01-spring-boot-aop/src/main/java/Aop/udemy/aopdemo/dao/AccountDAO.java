package Aop.udemy.aopdemo.dao;

import Aop.udemy.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();
}
