package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	//Constructor injection
	public EmployeeController (EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// Çalışanları bu liste databaseden alacaktır
		List<Employee>theEmployees= employeeService.findAll();


		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}
	@GetMapping("/showFormForAdd")
	public String showFromForAdd(Model theModel){

		// verileri baglamak için model attribute oluşturuyoruz
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee",theEmployee);
		return "employees/employee-form";
	}

	@GetMapping("/showFromUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);
		// set employee in the model to prepopulate the form
		theModel.addAttribute("employee",theEmployee);
		// sen over to our form

		return "employees/employee-form";
	}

	@GetMapping("/delete")
	public String delete (@RequestParam("employeeId") int theId){
		// Remove attribute
		employeeService.deleteById(theId);

		return "redirect:employees/list";
	}

	// Form için verileri kaydetme butonuna eşleyecek kodu yazıyoruz
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

		// save employee
		employeeService.save(theEmployee);

		// use a redirect to prevent duplicate submissions
		return "redirect://employees/list";
	}
}









