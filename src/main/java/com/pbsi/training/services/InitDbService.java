package com.pbsi.training.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbsi.training.entities.Employer;
import com.pbsi.training.entities.Job;
import com.pbsi.training.entities.Occupations;
import com.pbsi.training.repositories.EmployeeRepository;
import com.pbsi.training.repositories.EmployerRepository;
import com.pbsi.training.repositories.JobRepository;
import com.pbsi.training.repositories.OccupationRepository;


@Transactional
@Service
public class InitDbService {

	@Autowired
	EmployerRepository employerRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired 
	JobRepository jobRepository;
	
	@Autowired
	OccupationRepository occupationRepository;

	/**
	 * This method will be called after creation of the application context
	 */
	@PostConstruct
	public void init() {
		
		List<Occupations> occupationsList=occupationRepository.findAll();
		if(occupationsList==null || occupationsList.size()==0){

		Occupations occupation1 = new Occupations();
		occupation1.setName("Chef");

		Occupations occupation2 = new Occupations();
		occupation2.setName("Waiter");

		Occupations occupation3 = new Occupations();
		occupation3.setName("Cleaner");

		Occupations occupation4 = new Occupations();
		occupation4.setName("Attender");

		occupationRepository.save(occupation1);
		occupationRepository.save(occupation2);
		occupationRepository.save(occupation3);
		occupationRepository.save(occupation4);

		Employer employer1 = new Employer();
		employer1.setFirstName("John");
		employer1.setLastName("Smith");
		employer1.setPassword("password");
		employer1.setUserId("johnsmith");

		employerRepository.save(employer1);

		Job job1 = new Job();
		job1.setJobDescription("Do Java Training Task.......");
		job1.setJobTitle("Spring Java Tutorial");
		job1.setJobTitle("Spring Java Tutorial");
		job1.setPostedBy("johnsmith");
		jobRepository.save(job1);
		}

	}
}
