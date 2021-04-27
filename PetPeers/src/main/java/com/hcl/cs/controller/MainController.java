package com.hcl.cs.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	Logger logger=Logger.getLogger(MainController.class);
	
	/*@Autowired
	private User user;*/
	
	@RequestMapping(value="/saveUser")
	public String saveUser(){
		if(true){
			return "loginPage";
		}
		else {
			return "registrationPage";
		}
		
	}
	
	@RequestMapping(value="/authenticateUser")
	public String authenticateUser() {
		if(true) {
			return "homePage";
		}
		else {
			return "loginPage";
		}
	}
	
	
	@RequestMapping(value="/logout")
	public String logout() {
		return "loginPage";
	}
	

}
