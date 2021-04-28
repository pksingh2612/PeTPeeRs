package com.hcl.cs.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcl.cs.model.User;
import com.hcl.cs.service.UserService;

@Controller
public class UserLoginController {
	
	@Autowired
    @Qualifier("userLoginValidator")
    private Validator validator;
	
	@InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	Logger logger = Logger.getLogger(UserLoginController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(ModelMap map) {
		User user = new User();
		map.addAttribute("userLoginForm",user);
		return "loginPage";
	}
	
	@RequestMapping(value="/authenticateUser",method=RequestMethod.POST)
	public String authenticateUser(@Validated @ModelAttribute("userLoginForm") User user,BindingResult result,ModelMap map) {
		String viewPage="";
		if(result.hasErrors()) {
			viewPage="loginPage";
		}
		else {
			System.out.println(user.getUserName()+user.getUserPassword());
			User user1=userService.authenticateUser(user.getUserName(), user.getUserPassword());
			if(user1 != null) {
				viewPage="redirect:/home";
			}
			else {
				viewPage="redirect:/login";
			}
		}
			return viewPage;
	}
}
