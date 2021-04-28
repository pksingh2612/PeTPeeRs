package com.hcl.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import com.hcl.cs.model.Pet;
import com.hcl.cs.model.User;
import com.hcl.cs.service.PetService;
import com.hcl.cs.service.UserService;

@Controller
public class PetController {
	
	Logger logger = Logger.getLogger(PetController.class);
	
	@Autowired
	private PetService petService;
	
	@RequestMapping(value="/home")
	public String home(ModelMap map) {
		List<Pet> petList = petService.getAllPets();
		map.addAttribute("petList",petList);
		return "homePage";
	}

	@RequestMapping(value="/savePet",method=RequestMethod.POST)
	public String savePet(@Validated @ModelAttribute("petForm") Pet pet,BindingResult result) {
		logger.info("Inside savePet() ");
		String viewPage="";
		if(result.hasErrors()) {
			viewPage="addPetPage";
		}
		else {
			petService.savePet(pet);
			viewPage="redirect:/home";
		}
		return viewPage;
	}
	
	@RequestMapping(value="/myPets",method=RequestMethod.GET)
	public String myPets(HttpServletRequest request,ModelMap map) {
		List<Pet> petList = petService.getMyPet((long) request.getSession().getAttribute("userid"));
		map.addAttribute("petList",petList);
		return "myPetsPage";
	}
	
	@RequestMapping(value="/addPet",method=RequestMethod.GET)
	public String addPet(ModelMap map) {
		Pet pet = new Pet();
		map.addAttribute("petForm",pet);
		return "addPetPage";
	}
	
	@RequestMapping(value="/buyPet/{pid}",method=RequestMethod.GET)
	public String buyPet(HttpServletRequest request,@PathVariable("pid") long petId) {
		petService.buyPet((long) request.getSession().getAttribute("userid"),petId);
		return "redirect:/myPets";
	}
	
}
