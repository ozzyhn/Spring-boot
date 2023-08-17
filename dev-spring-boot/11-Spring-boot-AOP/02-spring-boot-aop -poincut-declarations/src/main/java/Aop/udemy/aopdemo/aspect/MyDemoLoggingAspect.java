package Aop.udemy.aopdemo.aspect;

import Aop.udemy.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Around("execution(* Aop.udemy.aopdemo.dao.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoin) throws Throwable {

        // print out method we are advising on
        String method= theProceedingJoin.getSignature().toShortString();
        System.out.println("Executing @Around method:" + method);
        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now lets execude
        Object result = null;

          try {
              result = theProceedingJoin.proceed();
          } catch (Exception exc){
              //log the exception
                System.out.println(exc.getMessage());

                // rethrow exception
              throw exc;

          }

        // get end timestap
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println(" duration :"+ duration/100.0);

        return result;

    }

    @After("execution(* Aop.udemy.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        // print out whic method we are advesing on
        String method= theJoinPoint.getSignature().toShortString();
        System.out.println("Executing @After method:" + method);

    }

    @AfterThrowing(
            pointcut = "execution(* Aop.udemy.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint ,Throwable theExc){

        // print out whic method we are advesing on
        String method= theJoinPoint.getSignature().toShortString();
        System.out.println("Executing @AfterThrowing method:" + method);

        //log the exception
        System.out.println("the exception" + method);

    }

    // add a new advice for @Afterreturning on the findaccounts

    @AfterReturning(
            pointcut = "execution(* Aop.udemy.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning="result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        // print out whic method we are advising
        String method= theJoinPoint.getSignature().toShortString();
        System.out.println("Executing @AfterReturning method:" + method);

        // print out the result method call
        System.out.println("Executing result is:" + result);

        // lets post-process the data...

        // convert the account names to uppercases

        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account>result) {

        // loop through accounts
        for (Account tempAccount: result){

            // get uppercase version of name
            String theUpperName= tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);

        }



    }

    @Pointcut("execution(* Aop.udemy.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){

    }

    //CREATE a pointcut getter methods
    @Pointcut("execution(* Aop.udemy.aopdemo.dao.*.*get(..))")
    private void getter(){}
    //CREATE a pointcut setter methods
    @Pointcut("execution(* Aop.udemy.aopdemo.dao.*.*set(..))")
    private void setter(){}
    // CREATE pointcut: include package .. exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter()) ")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccount(JoinPoint theJoinPoint){

        // display the method signature
        MethodSignature methodSignature= (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method signature:  "+ methodSignature);

        // display method arguments


        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg: args){
            System.out.println(tempArg);
            if (tempArg instanceof Account){

                // downcast and print accout specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name:"+ theAccount.getName());
                System.out.println("account level:"+ theAccount.getLevel());
            }
        }



    }


}
