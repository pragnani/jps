package com.pbsi.training.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbsi.training.entities.Employee;
import com.pbsi.training.entities.Job;
import com.pbsi.training.entities.Occupations;
import com.pbsi.training.repositories.EmployeeRepository;
import com.pbsi.training.repositories.EmployerRepository;
import com.pbsi.training.repositories.JobRepository;
import com.pbsi.training.repositories.OccupationRepository;

@Transactional
@Service
public class EmployeeService {

	/**
	 * Spring will place (instantiate) the autowired objects, also known as Dependency Injection
	 */
	
	
	
	@Autowired
	EmployerRepository employerRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired 
	JobRepository jobRepository;
	
	@Autowired
	OccupationRepository occupationRepository;
	

	/**
	 * Method to get all jobs posted
	 * @return
	 */
	public List<Job> findAllJobs() {
		return jobRepository.findAll();
	}

	/**
	 * Method to get All Occupations
	 * @return
	 */
	public List<Occupations> findAllOccupations() {
		return occupationRepository.findAll();
	}

	/**
	 * Method to save Employee object into database
	 * @param employee
	 */
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	/**
	 * Method to get all employees from the database
	 * @return
	 */
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}


	/**
	 * method to get the employee by Id
	 * @param username
	 * @return
	 */
	public Employee findEmployeeByUserId(String username) {
		// TODO Auto-generated method stub
		return employeeRepository.findByUserId(username);
	}

}
