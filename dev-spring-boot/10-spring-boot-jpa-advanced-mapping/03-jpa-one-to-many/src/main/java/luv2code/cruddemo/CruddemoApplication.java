package luv2code.cruddemo;

import ch.qos.logback.core.CoreConstants;
import luv2code.cruddemo.dao.AppDAO;
import luv2code.cruddemo.entity.Course;
import luv2code.cruddemo.entity.Instructor;
import luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

			//deleteInstructorDetailById(appDAO);

			//createInstructorWithCourses(appDAO);
			
			//findInstructorWithCourses(appDAO);

			//findCoursesForInstructor(appDAO);

			//findInstructorWithCoursesJoinFetch(appDAO);

			//updateInstructor(appDAO);

			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=10;

		appDAO.deleteCourseById(theId);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("finding ınstructor ıd:"+ theId);
		Instructor tempInstructor= appDAO.findInstructorById(theId);

		//update the instructor
		System.out.println("Updating instructor id: " +theId);
		tempInstructor.setLastName("TESTER");   //burda soy adını değiştirdik

		appDAO.update(tempInstructor);

		System.out.println("done");

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId=1;

		//Find the ınstructor
		System.out.println("Finding ınstructor ıd"+theId);
		 Instructor tempInstructor= appDAO.findInstructorByIdJoinFetch(theId);
		 System.out.println("Instructor"+tempInstructor);

		 //associated
		 System.out.println("associated: " +tempInstructor.getCourses());

		System.out.println("done");

	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		// İnstructoru bulmak ve yazdırmak için 4 satır kod yeterli
		int theId=1;
		System.out.println("Finding ınstructor ıd");

		Instructor tempInstructor= appDAO.findInstructorById(theId);
		System.out.println("tempınstructor: "+ tempInstructor);


		//Find Courses for instructor
		System.out.println("Finding courses for instructor ıd: "+theId);
		List<Course> courses =appDAO.findCoursesByInstructorId(theId);
		// associated the object
		tempInstructor.setCourses(courses);

		System.out.println("associated courses: "+ tempInstructor.getCourses());

		System.out.println("Done: ");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding ınstructor ID");

		Instructor tempInstructor= appDAO.findInstructorById(theId);
		System.out.println("tempınstructor: "+ tempInstructor);
		System.out.println("the associated courses: "+ tempInstructor.getCourses());
		System.out.println("Done: ");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor =
				new Instructor("susan","public","susan.public@gmail");
		// create ınstructor detail
		InstructorDetail tempInstructorDetail=
				new InstructorDetail(
						"GYM",
						"https youtube.com "
				);
		// nesneleri ilişkilendirmek
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//Create Some couses
		Course tempCourse1= new Course("air guitar-the ultimate");
		Course tempCourse2= new Course("pinball masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// SAVE THE İNSTRUCTOR
		// aynı zamanda kursları da kaydedecektir çünkü cascade type persist
		System.out.println("saving instructor:"+ tempInstructor);
		System.out.println("saving courses:" +tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("done");
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
