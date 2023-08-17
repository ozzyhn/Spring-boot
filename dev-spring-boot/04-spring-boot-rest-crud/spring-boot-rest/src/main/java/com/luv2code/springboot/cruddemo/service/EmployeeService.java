package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public interface EmployeeService {
	List<Employee>findAll();
	
   Employee findById(int theId);
	
	Employee save (Employee theEmployee);
	
	void deleteById(int theId);

}
