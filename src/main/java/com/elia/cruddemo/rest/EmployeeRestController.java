package com.elia.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// Expose GET "/employees" and return the list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
	
		return employeeService.findAll();
	
	}
	
	// Expose GET "/employees/{employeeId}" and return the employee
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
	
		Employee employee = employeeService.findById(employeeId);
	
		if (employee == null)
			throw new RuntimeException("Employee ID " + employeeId + " not found!");
		
		return employee;
		
	}
	
	// Expoose POST "/employees" for adding a new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		// Set the ID to 0 to force the insert instead of the update
		employee.setId(0);
		employeeService.save(employee);
		
		return employee;
		
	}
	
	// Expose PUT "/employees" for updating an employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
	}
	
	// Expose DELETE "/employees/{employeeId}" to delete an employee
	
}
