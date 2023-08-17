package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Employee;
//                                                                                                                            varlık türü // primary key
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}
