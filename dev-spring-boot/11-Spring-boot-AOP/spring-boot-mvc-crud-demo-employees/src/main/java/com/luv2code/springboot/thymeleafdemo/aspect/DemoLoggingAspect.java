package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {


    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // set up poincut declaration
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    //do the same for service and dao
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // add @before Advice

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        //display method we are calling
        String theMethod= theJoinPoint.getSignature().toShortString();
        myLogger.info(" @Before calling method:"+ theMethod); // Bu şekilde günlüğe info olarka kaydediyoruz


        // display the arguments to the methods


        //get the arguments
        Object[] args= theJoinPoint.getArgs();

        //loop thru and display args
        for (Object tempArg: args) {
            myLogger.info("argument: "+args);
        }


    }


        //after Returning
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult" // bu deger alttakı nesne değeri ile eşleşmelidir
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){

        // display method we are returning from
        String theMethod= theJoinPoint.getSignature().toShortString();
        myLogger.info(" @AfterReturning from method:"+ theMethod);

        //display data returned
        myLogger.info("msg result" +theResult);
    }

}
