package com.hcl.cs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.cs.model.User;

public class MainController {
	Logger logger=Logger.getLogger(MainController.class);
	
	@Autowired
	private User user;
	
	@RequestMapping(value="/saveUser")
	public String saveUser(@ModelAttribute("user") User user){
		if(){
			return "SuccessloginPage";
		}
		else {
			return "registrationPage";
		}
		
	}
	
	@RequestMapping(value="/authenticateUser")
	public String authenticateUser(HttpServletRequest request, @ModelAttribute("user") User user) {
		if() {
			return "SuccesshomePage";
		}
		else {
			return "loginPage";
		}
	}
	
	@RequestMapping(value="/home")
	public String home() {
		return "homePage";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) {
		return "loginPage";
	}
	

}
