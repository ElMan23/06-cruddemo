package com.elia.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elia.cruddemo.dao.EmployeeDAO;
import com.elia.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//
	// Properties
	//
	
	private EmployeeDAO employeeDAO;
	
	//
	// Constructors
	//
	
	// Inject the Employee DAO
	@Autowired
	public EmployeeRestController(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	//
	// Controller methods
	//
	
	// Expose "/employees" and return the list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}
	
}
