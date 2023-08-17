package Aop.udemy.aopdemo;

import Aop.udemy.aopdemo.dao.AccountDAO;
import Aop.udemy.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean // sayesinde otomatık olarak bagımlılık enjekte edilecektir autowired gerek yok
	public CommandLineRunner commandLineRunner (AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		return runner -> {

			demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount= new Account();

		theAccountDAO.addAccount(myAccount,true);

		theAccountDAO.doWork();

		// CAll the membership method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
	}

}
