package com.hcl.cs.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;

import com.hcl.cs.model.User;

@Controller
public class MainController {
	Logger logger=Logger.getLogger(MainController.class);
	
	/*@Autowired
	private User user;*/
	
	@Autowired
    @Qualifier("userValidator")
    private Validator validator;
	
	@InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(ModelMap map) {
		User user = new User();
		map.addAttribute("userForm",user);
		return "loginPage";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(ModelMap map) {
		User user = new User();
		map.addAttribute("userForm",user);
		return "registrationPage";
	}
	
	@RequestMapping(value="/saveUser")
	public String saveUser(@Validated @ModelAttribute("userForm") User user,BindingResult result,ModelMap map){
		String viewPage="";
		if(result.hasErrors()) {
			viewPage="registrationPage";
		}
		else {
			//map.addAttribute("petList",pet);
			viewPage="loginPage";
		}
		return viewPage;
		
	}
	
	@RequestMapping(value="/authenticateUser",method=RequestMethod.POST)
	public String authenticateUser(@Validated @ModelAttribute("userForm") User user,BindingResult result,ModelMap map) {
		String viewPage="";
		if(result.hasErrors()) {
			viewPage="loginPage";
		}
		else {
			//map.addAttribute("petList",pet);
			viewPage="homePage";
		}
		return viewPage;
	}
	
	
	@RequestMapping(value="/logout")
	public String logout() {
		return "loginPage";
	}
	

}
