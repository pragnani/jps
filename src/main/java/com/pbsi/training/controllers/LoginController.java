package com.pbsi.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pbsi.training.services.EmployeeService;
import com.pbsi.training.services.EmployerService;

@Controller
public class LoginController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployerService employerService;

//	/**
//	 * This method will create a model attribute
//	 * @return
//	 */
//	@ModelAttribute("login")
//	public Employee Construct() {
//		return new Employee();
//	}

	/**
	 * This method will be invoked when the user click login menu button in main menu
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

//	/****
//	 * This method will be invoked when the user submit login
//	 * 
//	 * First we will if the user exist in the employee Table, if the user exist in the table then we will verify his password
//	 * if the password is wrong or user doesn't exist then we will check again in employer table. We will do the same with employer
//	 * 
//	 * 
//	 * @param employee
//	 * @return
//	 */
//	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String doLogin(@ModelAttribute Employee employee) {
//		String username = employee.getUserId();
//		String password = employee.getPassword();
//
//		Employee employee1 = employeeService.findEmployeeByUserId(username);
//		if (employee1 != null) {
//			if (employee1.getPassword().equals(password)) {
//				return "WEB-INF/jsp/index.jsp";
//			} else {
//				return "redirect:/login.html?failure=true";
//			}
//		} else {
//			Employer employer = employerService.findEmployeeByUserId(username);
//			
//			if (employer != null) {
//				if (employer.getPassword().equals(password)) {
//					return "WEB-INF/jsp/index.jsp";
//				} else {
//					return "redirect:/login.html?failure=true";
//				}
//
//		}
//		}
//		return "redirect:/login.html?failure=true";
//	}

}
