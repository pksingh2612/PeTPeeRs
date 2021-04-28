package com.hcl.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index() {
		return "redirect:/login";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		return "loginPage";
	}

}
