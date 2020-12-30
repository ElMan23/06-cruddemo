package com.elia.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elia.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//
	// Fields for Entity Manager
	//
	
	private EntityManager entityManager;
	
	//
	// Set up constructor injection
	//
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		// Get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Create a query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		// Execute the query
		List<Employee> employees = query.getResultList();
		
		// Return the results
		return employees;
	}

}
