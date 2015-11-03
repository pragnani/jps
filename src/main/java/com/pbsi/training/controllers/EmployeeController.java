package com.pbsi.training.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbsi.training.entities.Employee;
import com.pbsi.training.entities.Job;
import com.pbsi.training.entities.Occupations;
import com.pbsi.training.services.EmployeeService;

@Controller
public class EmployeeController {

	/**
	 * Spring will automatically place autowired objects in your code
	 */
	@Autowired
	private EmployeeService employeeService;

	/**
	 * This will create a model Attribute named Employee, This is same as
	 * commandName we have entered in the registration page, Spring will
	 * automatically instantiate this object with the form values
	 * 
	 * @return
	 */
	@ModelAttribute("employee")
	Employee createEmployee() {
		return new Employee();
	}

	@ModelAttribute("jobs")
	List<Job> getJobs() {
		return employeeService.findAllJobs();
	}

	@ModelAttribute("occupations")
	List<Occupations> getAllJobOccupations() {
		return employeeService.findAllOccupations();
	}

	/**
	 * This method will get all the jobs from the database, along with its Post
	 * author
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping("/joblistings")
	public String jobs(Model model, HttpServletRequest request) {
		return "joblistings";
	}

	/**
	 * This method will take us to the employee Registration page, We are
	 * getting occupation values form the DB to populate them in the DropDown in
	 * our registration page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/register")
	public String doRegister(Model model) {
		return "registration";
	}

	/**
	 * This method will be invoked when the user submit the Registration form,
	 * This will save employee details into the datbase
	 * 
	 * @param employee
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveRegistration(@ModelAttribute Employee employee) {
		employeeService.save(employee);
		return "redirect:/register?success=true";
	}

	/**
	 * This method will be invoked when user click on the employee menu item,
	 * this will redirect to the employees page. We are getting all the employee
	 * names from the database and then we are showing them in our jsp
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/employees")
	public String showEmployees(Model model) {
		List<Employee> employees = employeeService.findAllEmployees();
		model.addAttribute("employees", employees);
		return "employees";
	}

}
