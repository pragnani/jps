package com.pbsi.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pbsi.training.entities.Employer;
import com.pbsi.training.entities.Job;
import com.pbsi.training.services.EmployeeService;
import com.pbsi.training.services.EmployerService;

@Controller
public class WebServiceController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployerService employerService;

	@RequestMapping(value = "/getallJobs", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Job getAllJobs() {
		return employeeService.findAllJobs().get(0);
	}

	
	@RequestMapping(value = "/getEmpById", method = RequestMethod.POST)
	public @ResponseBody Employer getJobById(@RequestParam(value = "username", defaultValue = "test") String username) {
		Employer employer = employerService.findEmployerByUserId(username);
		return employer;
	}

}
