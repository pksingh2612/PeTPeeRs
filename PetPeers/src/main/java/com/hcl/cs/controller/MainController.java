package com.hcl.cs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index() {
		return "redirect:/login";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login";
	}

}
