package Aop.udemy.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
    @Override
    public String getFortune() {

        // simuleta a delay

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // return a fortune

        return "except heavy traffic";

    }

    @Override
    public String getFortune(boolean tripWire) {

        if (tripWire){
            throw new RuntimeException("major accident");
        }

        return getFortune();
    }
}
