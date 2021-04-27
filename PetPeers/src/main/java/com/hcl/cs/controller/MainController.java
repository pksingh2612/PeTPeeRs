package com.hcl.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;
import com.hcl.cs.model.Pet;

@Controller
public class MainController {
	Logger logger = Logger.getLogger(MainController.class);
	//myPets(HttpServletRequest request)
	
	@RequestMapping(value="/myPets",method=RequestMethod.GET)
	public String myPets() {
		return "myPetsPage";
	}
	
	@RequestMapping(value="/addPet",method=RequestMethod.GET)
	public String addPet(ModelMap map) {
		Pet pet = new Pet();
		map.addAttribute("petForm",pet);
		return "addPetPage";
	}
	
	@RequestMapping(value="/home")
	public String home() {
		return "homePage";
	}
	
	//savePet(@ModelAttribute("pet") Pet pet)

	@RequestMapping(value="/savePet",method=RequestMethod.POST)
	public String savePet(@Validated @ModelAttribute("petForm") Pet pet,BindingResult result,ModelMap map) {
		logger.info("Inside savePet() ");
		String viewPage="";
		if(result.hasErrors()) {
			viewPage="addPetPage";
		}
		else {
			//map.addAttribute("petList",pet);
			viewPage="homePage";
		}
		return viewPage;
	}

	//buyPet(HttpServletRequest request)
	
	@RequestMapping(value="/buyPet",method=RequestMethod.GET)
	public String buyPet() {
		return "redirect:/myPets";
	}
}
