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
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(ModelMap map,HttpServletRequest request) {
		logger.info("Inside home()  pet controller ");	
		String viewPage="";
		
		if(request.getSession().getAttribute("sessionStatus") != null) {
			List<Pet> petList = petService.getAllPets();
			map.addAttribute("petList",petList);
			viewPage="homePage";
		}
		else {
			viewPage="redirect:/login";
		}
		
		return viewPage;
	}

	@RequestMapping(value="/savePet",method=RequestMethod.POST)
	public String savePet(@Validated @ModelAttribute("petForm") Pet pet,BindingResult result,HttpServletRequest request) {
		logger.info("Inside savePet()  pet controller ");		
        String viewPage="";
		
		if(request.getSession().getAttribute("sessionStatus") != null) {
			if(result.hasErrors()) {
				viewPage="addPetPage";
			}
			else {
				petService.savePet(pet);
				viewPage="redirect:/home";
			}
		}
		else {
			viewPage="redirect:/login";
		}
		
		return viewPage;
	}
	
	@RequestMapping(value="/myPets",method=RequestMethod.GET)
	public String myPets(HttpServletRequest request,ModelMap map) {
		logger.info("Inside myPets()  pet controller ");
        String viewPage="";
		
		if(request.getSession().getAttribute("sessionStatus") != null) {
			List<Pet> petList = petService.getMyPet((long) request.getSession().getAttribute("userid"));
			map.addAttribute("petList",petList);
			viewPage="myPetsPage";
		}
		else {
			viewPage="redirect:/login";
		}
		
		return viewPage;
	}
	
	@RequestMapping(value="/addPet",method=RequestMethod.GET)
	public String addPet(HttpServletRequest request, ModelMap map) {
		logger.info("Inside addPet()  pet controller ");
		String viewPage="";
		
		if(request.getSession().getAttribute("sessionStatus") != null) {
			Pet pet = new Pet();
			map.addAttribute("petForm",pet);
			viewPage="addPetPage";
		}
		else {
			viewPage="redirect:/login";
		}
		
		return viewPage;
	}
	
	@RequestMapping(value="/buyPet/{pid}",method=RequestMethod.GET)
	public String buyPet(HttpServletRequest request,@PathVariable("pid") long petId) {
		logger.info("Inside buyPet()  pet controller ");
		String viewPage="";
		
		if(request.getSession().getAttribute("sessionStatus") != null) {
			petService.buyPet((long) request.getSession().getAttribute("userid"),petId);
			viewPage="redirect:/myPets";
		}
		else {
			viewPage="redirect:/login";
		}
		
		return viewPage;
	}
	
}
