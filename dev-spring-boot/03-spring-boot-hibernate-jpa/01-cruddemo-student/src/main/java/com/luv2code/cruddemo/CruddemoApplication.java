package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner  commandLineRunner(StudentDAO studentDAO) {
		
		return runner -> {
			//createStudent (studentDAO);
			
//			createMultipleStudent(studentDAO);
//			readStudent (studentDAO);
			
//			queryForStudents(studentDAO);
			
//			queryForStudentsByLastName(studentDAO);
			
//			updateStudent(studentDAO);
			
//			deleteStudent(studentDAO);
			
//			deleteAllStudents(studentDAO);
		};
	}
	
	private void deleteAllStudents(StudentDAO studentDAO) {
		
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleting row count :"+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// 3 numaralı kişinin STUDEN ID Yİ SİLMEK İSTİYORUZ
		
		int studentId=3;
		System.out.println("Deleting student id:"+ studentId);
		studentDAO.delete(studentId);   // DAO elemanindan studentId yi siliyorum
	}
	
	private void updateStudent(StudentDAO studentDAO) {
		
		//retrieve student based on the id: primary key
		int studentId=1;
		System.out.println("Getting student with id:"+ studentId);      
		Student myStudent= studentDAO.findbyId(studentId);       // Öğrencinin ID sini bulduk
			
		// change first name "Scooby"
			System.out.println("Updating student");
			myStudent.setFirstName("Scooby");   // Öğrencinin ilk adını değiştirdik
			
		//update Student
			studentDAO.update(myStudent);
		// display update student
			System.out.println("Update student:"+ myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//Get a list of students
		List<Student>theStudents=studentDAO.findByLastName("duck");
		
		// display list of students
		for (Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}
	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents= studentDAO.findAll();
		
		// display list of students
			for(Student tempStudent: theStudents) {
				System.out.println(tempStudent);
			}
	}

	private void readStudent(StudentDAO studentDAO) {
		
		//Create STUDENT OBJECT
		System.out.println("Create new student object");
		Student tempStudent = new Student ("daffy","duck","@hotmail.com");
		
		// Save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		// Display id of the saved student
		int theId= tempStudent.getId();
		System.out.println("Student ıd :"+ theId);
		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with ıd:"+theId);
		Student myStudent= studentDAO.findbyId(theId);
		
		// display student
		System.out.println("Found the student"+myStudent);
	}
	private void createMultipleStudent(StudentDAO studentDAO) {
		
		// Create multiple students
		// Student sınıfından create multiple student nesnesni üretiyoruz
		System.out.println("Creating new student");
		Student multiplestudent = new Student("ali","veli","@hotmail.com");
		Student multiplestudent2 = new Student("kerim","veli","@hotmail.com");
		Student multiplestudent3 = new Student("cabbar","veli","@hotmail.com");
		
		// Save the students
		System.out.println("Saving the student");
		//StudentDAO sayesinde veritabanına kayıt yapıyoruz
		studentDAO.save(multiplestudent);
		studentDAO.save(multiplestudent2);
		studentDAO.save(multiplestudent3);
		
		// Display id of the save students
		//GET ID metoduyla ıd lerini ekrana getiriyoruz
		System.out.println("student id: "+ multiplestudent.getId());
		System.out.println("student id: "+ multiplestudent2.getId());
		System.out.println("student id: "+ multiplestudent3.getId());
	}

//	private void createStudent(StudentDAO studentDAO) {
//		
//		//CREATE the student object
//		System.out.println("Creating new student object...");
//		Student student= new Student("paul", "doe", "lov2code.com");
//		
//		// save the student object
//		System.out.println("saving the student");
//		studentDAO.save(student);
//		
//		//display id of the saved student
//		
//		System.out.println("saved studen id:"+student.getId());
		
	//}

}
