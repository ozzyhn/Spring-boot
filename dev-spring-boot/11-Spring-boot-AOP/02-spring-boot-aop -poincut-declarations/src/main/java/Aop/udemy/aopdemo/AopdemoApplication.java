package Aop.udemy.aopdemo;

import Aop.udemy.aopdemo.dao.AccountDAO;
import Aop.udemy.aopdemo.dao.MembershipDAO;
import Aop.udemy.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean // sayesinde otomatık olarak bagımlılık enjekte edilecektir autowired gerek yok
	public CommandLineRunner commandLineRunner (AccountDAO theAccountDAO,
												MembershipDAO theMembershipDAO
												, TrafficFortuneService theTrafficFortuneService
												) {

		return runner -> {

			//demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);

			//demoTheAfterReturningAdvice(theAccountDAO);

			//demoTheAfterThrowingAdvice(theAccountDAO);

			//demoTheAfterAdvice(theAccountDAO);
			
			//demoTheAroundAdvice(theTrafficFortuneService);

			//demoTheAroundAdviceHandleException(theTrafficFortuneService);

			demoTheAroundAdviceRethrowException(theTrafficFortuneService);


		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("Calling demoTheAroundAdviceRethrowException getFortune");

		// verileri cagırma

		boolean tripWire= true;
		String data= theTrafficFortuneService.getFortune(tripWire);

		System.out.println("Myfrotune is" + data);
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("Calling getFortune");

		// verileri cagırma

		boolean tripWire= true;
		String data= theTrafficFortuneService.getFortune(tripWire);

		System.out.println("Myfrotune is" + data);
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("Calling getFortune");
		// verileri cagırma
		String data= theTrafficFortuneService.getFortune();
		System.out.println("Myfortune is" + data);
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {

		// call method find accounts

		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;

			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception exc) {
			System.out.println("\n\n Main program: demoTheAfterThrowingAdvice advice" + exc);

		}

		// display the accounts

		System.out.println("\n\n Main program: demoTheAfterThrowingAdvice advice");

		System.out.println(theAccounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		// call method find accounts

		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;

			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception exc) {
			System.out.println("\n\n Main program: demoTheAfterThrowingAdvice advice" + exc);

		}

		// display the accounts

		System.out.println("\n\n Main program: demoTheAfterThrowingAdvice advice");

		System.out.println(theAccounts);


	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO){

		// call method find accounts

		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts

		System.out.println("\n\n Main program: demotheAfterReturning advice");

		System.out.println(theAccounts);

	}
	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount= new Account();
		myAccount.setName("mahdu");
		myAccount.setLevel("beginner");
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();

		//  call the accountda getter/setter methods

		// set
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		// get
		String name = theAccountDAO.getName();
		String code= theAccountDAO.getServiceCode();

		// CAll the membership method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
	}

}
