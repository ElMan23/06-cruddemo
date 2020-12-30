package com.elia.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elia.cruddemo.dao.EmployeeRepository;
import com.elia.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
		
	}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
		
	}

	@Override
	public Employee findById(int id) {

		
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		if (result.isPresent())
			employee = result.get();
		
		return employee;
		
	}

	@Override
	public void save(Employee employee) {

		employeeRepository.save(employee);
		
	}

	@Override
	public void deleteById(int id) {

		employeeRepository.deleteById(id);
		
	}

}
