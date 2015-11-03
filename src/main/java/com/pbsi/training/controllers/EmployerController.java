package com.pbsi.training.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbsi.training.entities.Employer;
import com.pbsi.training.entities.Job;
import com.pbsi.training.services.EmployerService;

@Controller
public class EmployerController {

	/**
	 * Spring will place  object for when we AutoWire
	 */
	@Autowired
	private EmployerService employerService;
	
	

	/**
	 * Creating a model attribute to save employer object, This will automatically place the content we entered in the form to 
	 * corresponding employer object
	 * @return
	 */
	private @ModelAttribute("employer") Employer createEmployee() {
		return new Employer();
	}
	
	/**
	 * This will create a model object with the name job, this will automatically place content entered in form into our object
	 * @return
	 */
	private @ModelAttribute("job") Job createJob() {
		return new Job();
	}

	/**
	 * Request mapping for Employer Registeration, this return a jsp page that need to show when user click employer register
	 * @param model
	 * @return
	 */
	@RequestMapping("/empregister")
	public String doRegister(Model model) {
		return "empregistration";
	}

	/**
	 * This method will be invoked when the user submit the form data, Model attribute will hold the data entered by user in the form
	 * 
	 * @param employer
	 * @return
	 */
	@RequestMapping(value = "/empregister", method = RequestMethod.POST)
	public String saveRegistration(@ModelAttribute Employer employer) {
		employerService.save(employer);
		return "redirect:/empregister?success=true";
	}
	
	/***
	 * This will redirect us to the job Posting page when user lick "Post Job" menu item in main menu
	 * @return
	 */
	
	@RequestMapping("/postjob")
	public String postJob()
	{
		return "jobposting";
	}
	
	/**
	 * This method will be invoked when the user submit the "Job Post", All the form data will be automatically saved into the model attribute
	 * @param job
	 * @return
	 */
	@RequestMapping(value = "/postjob", method = RequestMethod.POST)
	public String saveJob(@ModelAttribute Job job, Principal principal) {
		String username=principal.getName();
		job.setPostedBy(username);
		employerService.saveJob(job);
		return "redirect:/postjob?success=true";
	}

}
