package com.hcl.cs.controller;

import javax.servlet.http.HttpServletRequest;

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
	public String login(ModelMap map,HttpServletRequest request) {
		logger.info("Inside login() UserLogin Controller ");	
		String viewPage="";
		if(request.getSession().getAttribute("sessionStatus") != null) {
			viewPage="redirect:/home";
		}
		else {
			User user = new User();
			map.addAttribute("userForm",user);
			viewPage="loginPage";
		}
		
		return viewPage;
	}
	
	@RequestMapping(value="/authenticateUser",method=RequestMethod.POST)
	public String authenticateUser(@Validated @ModelAttribute("userForm") User user,BindingResult result,ModelMap map,HttpServletRequest request) {
		logger.info("Inside authenticateUser() UserLogin Controller ");
		String viewPage="";
		if(result.hasErrors()) {
			viewPage="loginPage";
		}
		else {
			User foundedUser=userService.authenticateUser(user.getUserName(), user.getUserPassword());
			if(foundedUser != null) {
				request.getSession().setAttribute("sessionStatus",true);
				request.getSession().setAttribute("userid",foundedUser.getUserId());
				request.getSession().setAttribute("username",foundedUser.getUserName());
				request.getSession().setAttribute("password",foundedUser.getUserPassword());
				viewPage="redirect:/home";
			}
			else {
				map.addAttribute("Msg","Either User Name or Password or both are invalid");
				map.addAttribute("colorMsg","red");
				viewPage="loginPage";
			}
		}
			return viewPage;
	}
}
