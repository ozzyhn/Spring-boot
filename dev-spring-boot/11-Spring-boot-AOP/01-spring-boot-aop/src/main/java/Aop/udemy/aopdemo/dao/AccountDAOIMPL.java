package Aop.udemy.aopdemo.dao;

import Aop.udemy.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository // sınıfı bileşen taraması için kullanılabilir hale getirir
public class AccountDAOIMPL implements AccountDAO {


    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {

        System.out.println(getClass()+"doing my db work: adding an account");

    }

    @Override
    public boolean doWork() {

        System.out.println(getClass()+"doWork()");
        return false;
    }
}
