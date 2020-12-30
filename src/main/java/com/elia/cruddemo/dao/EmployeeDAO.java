package com.elia.cruddemo.dao;

import java.util.List;

import com.elia.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();

}
