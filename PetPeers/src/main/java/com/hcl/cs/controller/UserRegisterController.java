package com.hcl.cs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;
import com.hcl.cs.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;

import com.hcl.cs.model.User;
import com.hcl.cs.service.UserService;


@Controller
public class UserRegisterController {
	
	
	@Autowired
    @Qualifier("userRegisterValidator")
    private Validator validator;
	
	@InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	Logger logger = Logger.getLogger(UserRegisterController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(ModelMap map) {
		User user = new User();
		map.addAttribute("userForm",user);
		return "registrationPage";
	}
	
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public String saveUser(@Validated @ModelAttribute("userForm") User user,BindingResult result,ModelMap map){
		String viewPage="";
		if(result.hasErrors()) {
			viewPage="registrationPage";
		}
		else {
			if(userService.checkUserByUserName(user.getUserName())!=null)
			{		
				map.addAttribute("Msg","User Name already in use. Please select a different User Name");
				map.addAttribute("colorMsg","red");
				viewPage="registrationPage";
			}
			else {
				//System.out.println(user.getUserName()+user.getUserPassword()+user.getConfirmPassword());
				userService.saveUser(user);
//				map.addAttribute("Msg","You are successfully registered. Please Login now");
//				map.addAttribute("colorMsg","green");
				viewPage="redirect:/login";
			}
		}
		return viewPage;
	}
	
}
