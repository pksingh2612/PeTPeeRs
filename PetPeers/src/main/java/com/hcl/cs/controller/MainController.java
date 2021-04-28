package com.hcl.cs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	Logger logger = Logger.getLogger(MainController.class);
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index() {
		logger.info("Inside index() main controller ");	
		return "redirect:/login";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		logger.info("Inside logout() main controller ");	
		String viewPage="";
		if(request.getSession().getAttribute("sessionStatus") != null) {
			request.getSession().invalidate();
			viewPage="redirect:/login";
		}
		else {
			viewPage="redirect:/login";
		}
		
		return viewPage;
	}

}
