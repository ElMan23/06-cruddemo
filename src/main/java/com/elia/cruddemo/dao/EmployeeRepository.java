package com.elia.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elia.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
