package com.pbsi.training.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbsi.training.entities.Employee;
import com.pbsi.training.entities.Employer;
import com.pbsi.training.entities.Job;
import com.pbsi.training.repositories.EmployeeRepository;
import com.pbsi.training.repositories.EmployerRepository;
import com.pbsi.training.repositories.JobRepository;

@Transactional
@Service
public class EmployerService {

	/**
	 * Spring will automatically instantiate the autowired objects
	 */
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired 
	JobRepository jobRepository;

	@Autowired
	EmployerRepository employerRepository;
	
	/**
	 * method to get all the employers from database
	 * 
	 * @return
	 */
	public List<Employee> findAllEmployee() {

		return employeeRepository.findAll();
	}

	/**
	 * Method to save Employer Details into database
	 * 
	 * @param employer
	 */
	public void save(Employer employer) {
		employerRepository.save(employer);
	}

	/**
	 * Method to find employee by UserName
	 * @param username
	 * @return
	 */
	public Employee findEmployeeByUserId(String username) {
		// TODO Auto-generated method stub
		return employeeRepository.findByUserId(username);
	}
	
	/**
	 * Method to find employee by UserName
	 * @param username
	 * @return
	 */
	public Employer findEmployerByUserId(String username) {
		// TODO Auto-generated method stub
		return employerRepository.findByUserId(username);
	}

	/**
	 * Method to save Job to the database
	 * @param job
	 */
	public void saveJob(Job job) {
		jobRepository.save(job);

	}

}
