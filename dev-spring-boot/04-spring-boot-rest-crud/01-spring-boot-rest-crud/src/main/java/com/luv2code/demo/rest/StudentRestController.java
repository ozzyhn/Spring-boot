package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;

	// define endpoint /student return list of students
	@PostConstruct   // Listenin sadece 1 kez oluşturulmasını sağlıyor
	public void loadData() {
		theStudents= new ArrayList<>();
		theStudents.add(new Student("Poornima","patel"));
		theStudents.add(new Student("mario","rossi"));
		theStudents.add(new Student("marry","smith"));
		
	}
	
	@GetMapping("/students")
	public List<Student>getStudents(){
		// Yukarı kısımda PostConstruc ile 1 kez oluşturulan lise sadece döndürülecek
		return theStudents;
		
	}
	
	// Define endpoint or "/students/{studentId}"-return student at index
	@GetMapping("/students/{studentId}")
	// Path Variable kısmı öğrenci kimligi döndürecegini gösteriyor    
	// get mapping kısmındaki ile path kısmındaki eşleşmeli studentId
	public Student getStudent(@PathVariable int studentId) {
		
		// just ındex into the list
		
		// check stıdentId again list size
		
		if ((studentId >=theStudents.size()) || (studentId <0) ) {
			throw new StudentNotFoundException("student id not found:" + studentId);
			
		}
		
		return theStudents.get(studentId);
		
	}
	
	
	//add an exception hadnler Using @Exception handler
	
	
}
