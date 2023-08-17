package Aop.udemy.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository // sınıfı bileşen taraması için kullanılabilir hale getirir
public class MembershipDAOIMPL implements MembershipDAO {


    @Override
    public void addSillyMember() {

        System.out.println(getClass()+"doing my db work: adding an membership account");

    }

    @Override
    public void goToSleep() {

        System.out.println(getClass()+"ı m going to sleep cya");

    }
}
