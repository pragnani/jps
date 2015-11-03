package com.pbsi.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	
	
	/***
	 * 
	 * This method will be invoked if somebody hit URl with the extentions we have registered in web.xml (*.html, *.htm etc..)
	 * It will navigate to the index page located in WEB-INF/jsp/index.jsp
	 */

	@RequestMapping("/index")
	public String welcome()
	{
		return "index";
	}
}
