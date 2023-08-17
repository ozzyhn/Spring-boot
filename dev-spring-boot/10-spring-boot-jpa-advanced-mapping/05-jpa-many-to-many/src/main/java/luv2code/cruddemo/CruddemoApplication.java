package luv2code.cruddemo;

import ch.qos.logback.core.CoreConstants;
import jakarta.transaction.Transactional;
import luv2code.cruddemo.dao.AppDAO;
import luv2code.cruddemo.entity.*;
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

			//createCourseAndStudents(appDAO);

			//findCourseAndStudents(appDAO);

			//findStudentAndCourses(appDAO);

			// addMoreCoursesForStudent(appDAO);

			//deleteCourse(appDAO);

			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting student  id: " +theId);

		appDAO.deleteStudentById(theId);
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int theId=2;
		// öğrenciyi getir
		Student tempStudent= appDAO.findStudentAndCoursesByStudentId(theId);

		//create more courses
		Course tempCourse1= new Course("pacman - how to score one million points");
		Course tempCourse2= new Course("zortman-zort maceralar");

		// add students course

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("saving students"+tempStudent);
		System.out.println("associated"+tempStudent.getCourses());

		appDAO.update(tempStudent);
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId=2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println("Loaded student: " + tempStudent);

		System.out.println("Courses: " + tempStudent.getCourses());

		System.out.println("DONE" );

	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId=10;
		Course tempCourse= appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course: " + tempCourse);

		System.out.println("Loaded student: " + tempCourse.getStudents());

		System.out.println("done");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course tempCourse= new Course("pacman - how to score one million points");

		// create the students
		Student tempStudent1 = new Student("john","doe","john@luv2code.com");
		Student tempStudent2 = new Student("mary","jane","marry@luv2code.com");
		// add students to the course
		 tempCourse.addStudent(tempStudent1);
		 tempCourse.addStudent(tempStudent2);
		// save the course and associated students
		System.out.println("Saving the course"+ tempCourse);
		System.out.println("associated"+ tempCourse.getStudents());

		appDAO.save(tempCourse);

		System.out.println("Done");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId= 10;

		System.out.println("Deleting a course and reviews" + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("DONE");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theId=10;
		Course tempCourse= appDAO.findCourseAndReviewsByCourseId(theId);

		// get the course reviews
		List<Review>reviews=tempCourse.getReviews();

		// print the course
		System.out.println("Course" +tempCourse);

		// print the reviews
		System.out.println("reviews" +tempCourse.getReviews());
	}


	private void createCourseAndReviews(AppDAO appDAO) {

		//create a course
		Course tempCourse=new Course("pacman-how to score one million");
		// add some reviews
		tempCourse.addReview(new Review("Great Course .. loved it"));
		tempCourse.addReview(new Review("cool .. loved it"));
		tempCourse.addReview(new Review("Great"));
		// save the course
		System.out.println("Saving");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done");
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
