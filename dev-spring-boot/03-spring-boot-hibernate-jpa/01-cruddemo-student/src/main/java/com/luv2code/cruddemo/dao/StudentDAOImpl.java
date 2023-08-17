package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Transactional
	@Override
	public int deleteAll() {
		
		int numRowsDeleted= entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsDeleted;
	}

	@Transactional
	public void  delete(Integer id) {
		
		//Retrieve the student  // öğrenciyi alcagız
		Student theStudent = entityManager.find(Student.class, id);
		
		//Delete Student  // öğrenciyi sileceğiz
		entityManager.remove(theStudent);
	}
	@Override
	@Transactional       // veri tabanında değişiklik yapabilir bu yüzden ekledik
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
		
	}
	
	//Define field for entity manager
	private EntityManager entityManager;
	
	// inject entitiy manager using constructor injection
	@Autowired
	public StudentDAOImpl( EntityManager entityManager) {
		this.entityManager= entityManager;
	}
	
	// implements save method
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
		
	}
	//Oluşturulan findby ıd metodu EntityManager ile öğrencinin sınıfını ve id sini buluyor
	public Student findbyId(Integer id) {
		return entityManager.find(Student.class,id);
		
	}

	@Override
	public List<Student> findAll() {
		// Create Query                                                                                                           JPA varlığı Veritabanı tablo adıdır
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ", Student.class);
		
		// Return query results
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		// Create query
		TypedQuery<Student>theQuery=entityManager.createQuery( 
				                                                    "FROM Student WHERE lastName=:theData",Student.class);
		// Set query parameters
		// the data yukarda verilen gerçek değerdir                           //The last name iste en başında kullandıgımız string değeri
		theQuery.setParameter("theData", theLastName);
		// return query results
		return theQuery.getResultList();
	}



}
