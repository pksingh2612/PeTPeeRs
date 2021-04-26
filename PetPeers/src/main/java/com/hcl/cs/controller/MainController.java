package com.hcl.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	//myPets(HttpServletRequest request)
	
	@RequestMapping(value="/myPets",method=RequestMethod.GET)
	public String myPets() {
		return "myPetsPage";
	}
	
	@RequestMapping(value="/addPet",method=RequestMethod.GET)
	public String addPet() {
		return "addPetPage";
	}
	
	@RequestMapping(value="/home")
	public String home() {
		return "homePage";
	}
	
	//savePet(@ModelAttribute("pet") Pet pet)
	
	@RequestMapping(value="/savePet",method=RequestMethod.GET)
	public String savePet() {
		return "homePage";
	}
	 
	//buyPet(HttpServletRequest request)
	
	@RequestMapping(value="/buyPet",method=RequestMethod.GET)
	public String buyPet() {
		return "redirect:/myPets";
	}
}
