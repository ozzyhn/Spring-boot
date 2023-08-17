package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//İnjection constructor
	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl (EmployeeDAO theEmployeeDAO) {
		employeeDAO= theEmployeeDAO;
	}
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}
	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(theId);
	}
	@Override
	@Transactional   // veri tabanını değiştirdiği için
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDAO.save(theEmployee);
	}
	@Override
	@Transactional   // veri tabanını değiştirdiği için
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeDAO.deleteById(theId);
	}

}
