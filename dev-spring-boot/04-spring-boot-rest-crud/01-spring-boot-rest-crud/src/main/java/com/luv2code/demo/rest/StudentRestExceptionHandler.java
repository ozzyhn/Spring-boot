package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // yazılan handler hata ayıklama kodunu küresel anlamda kullanmayı sağlar en iyi yoldur 
public class StudentRestExceptionHandler {

	// add exception handling code here

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse>handleException (StudentNotFoundException exc){
		
		//create  a studentErrorResponse
		
		StudentErrorResponse error= new StudentErrorResponse();
		
		// Burda hatamızın ismini veriyoruz not found hatası
		error.setStatus(HttpStatus.NOT_FOUND.value());
		//Burda hata verdikten sonra verilecek olan mesajı set ve get atıyoruz
		error.setMessage(exc.getMessage());
		//burda hatanın alındığı zamanı gösteriyoruz
		error.setTimeStamp(System.currentTimeMillis());
		//Return responseEntity
		//Bu kısımda hatayı döndürüp error ve not found göstermesini sağlıyoruz
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	// add another exception handler   to catch any exception
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		//create  a studentErrorResponse
		
		StudentErrorResponse error= new StudentErrorResponse();
		
		// Burda hatamızın ismini veriyoruz Bad request hatası
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		//Burda hata verdikten sonra verilecek olan mesajı set ve get atıyoruz
		error.setMessage(exc.getMessage());
		//burda hatanın alındığı zamanı gösteriyoruz
		error.setTimeStamp(System.currentTimeMillis());
		//Return responseEntity
		//Bu kısımda hatayı döndürüp error ve bad REQUESTgöstermesini sağlıyoruz
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
