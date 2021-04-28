package com.hcl.cs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcl.cs.model.Pet;

@Controller
public class MainController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index() {
		return "redirect:/login";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
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
