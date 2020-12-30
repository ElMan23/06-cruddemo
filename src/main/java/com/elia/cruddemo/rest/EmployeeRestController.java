package com.elia.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elia.cruddemo.entity.Employee;
import com.elia.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//
	// Properties
	//
	
	private EmployeeService employeeService;
	
	//
	// Constructors
	//
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	
	}
	
	//
	// Controller methods
	//
	
	// Expose "/employees" and return the list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
	
		return employeeService.findAll();
	
	}
	
	// Expose "/employees/{employeeId}" and return the employee
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
	
		return employeeService.findById(employeeId);
	
	}
	
}
