package Aop.udemy.aopdemo.dao;

import Aop.udemy.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository // sınıfı bileşen taraması için kullanılabilir hale getirir
public class AccountDAOIMPL implements AccountDAO {

    private String name;
    private String serviceCode;


    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {

        System.out.println(getClass()+"doing my db work: adding an account");

    }

    @Override
    public boolean doWork() {

        System.out.println(getClass()+"doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+"getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+"setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+"getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+"setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public List<Account> findAccounts(){
        return findAccounts(false);
    }
    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // for academic purposes
        if(tripWire) {
             throw new RuntimeException("hata");
        }

        List<Account>myAccounts= new ArrayList<>();

        // create sample accounts
        Account temp1= new Account("muhammmad","silver");
        Account temp2= new Account("cabbar","platinium");

        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);

        return myAccounts;

    }
}
