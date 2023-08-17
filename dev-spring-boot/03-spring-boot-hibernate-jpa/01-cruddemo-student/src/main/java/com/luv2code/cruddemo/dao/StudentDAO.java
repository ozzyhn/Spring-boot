package com.luv2code.cruddemo.dao;

import java.util.List;

import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {
	
	public void save(Student theStudent); 

	// yeni bir metod ekliyoruz
	Student findbyId(Integer id);
	
	// Yeni bir liste ve metod ekliyoruz find all dedipimiz anda öğrenci listesi getirecek
	List<Student> findAll();
	
	//Öğrenciyi soyadına göre bulmak için yni bir yöntem ekliyoruz
	List<Student>findByLastName(String theLastName);
	
	//Update metodu ekliyoruz
	void update (Student theStudent);
	
	// Delete metodu ekliyoruz
	void delete(Integer id);
	
	//Veritabanında kaç kişiyi sildiğimizi bilmek istediğimiz için int değer verdik
	int deleteAll();
}
