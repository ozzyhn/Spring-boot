package Aop.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this where we add all of our rleated advices for ligging

    // lets start with an @Before advice

    @Before("execution(* Aop.udemy.aopdemo.dao.*.*(..))")
    public void beforeAddAccount(){
        System.out.println("\n ===== Executing @before advice on addAccount()");
    }
}
