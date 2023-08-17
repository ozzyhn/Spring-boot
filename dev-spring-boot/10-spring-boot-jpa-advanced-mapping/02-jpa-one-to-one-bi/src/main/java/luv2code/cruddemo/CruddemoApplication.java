package luv2code.cruddemo;

import ch.qos.logback.core.CoreConstants;
import luv2code.cruddemo.dao.AppDAO;
import luv2code.cruddemo.entity.Instructor;
import luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO){
		return runner-> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetailById(appDAO);
			deleteInstructorDetailById(appDAO);

		};
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		int theId=3;
		System.out.println("Deleting instructor deail ıd:"+ theId);

		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done");
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		// get the instructor detail object
		int theId=2;
		InstructorDetail tempInstructorDetail= appDAO.findInstructorDetailById(theId);

		//print the instructor detail
		System.out.println("tempInstructorDetail :" +tempInstructorDetail);

		// print the associated instructor
		System.out.println("The associated instructor." +tempInstructorDetail.getInstructor());

		System.out.println("done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("deleting instructor id"+ theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("DONE");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("finding instructor id"+ theId);

		Instructor tempInstructor= appDAO.findInstructorById(theId);

		System.out.println("Tempınstructor:" + tempInstructor);

	}

	private void createInstructor(AppDAO appDAO){
	/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("chad","darby","email");
		// create ınstructor detail
		InstructorDetail tempInstructorDetail=
				new InstructorDetail(
						"https youtube ",
						"luv 2 code"
				);
		*/

		// create the instructor
		Instructor tempInstructor =
				new Instructor("mathu","patel","email");
		// create ınstructor detail
		InstructorDetail tempInstructorDetail=
				new InstructorDetail(
						"https youtube ",
						"luv 2 code"
				);


		// nesneleri ilişkilendirmek
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		System.out.println("saving instructor"+ tempInstructor);
		appDAO.save(tempInstructor);
	}
}
