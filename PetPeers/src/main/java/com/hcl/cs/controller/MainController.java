package com.hcl.cs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcl.cs.model.Pet;
import com.hcl.cs.model.User;
import com.hcl.cs.service.PetService;
import com.hcl.cs.service.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PetService petService;
	
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
	
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(ModelMap map,HttpServletRequest request) {	
		logger.info("Inside register() UserRegister Controller ");
		String viewPage="";
		if(request.getSession().getAttribute("sessionStatus") != null) {
			viewPage="redirect:/home";
		}
		else {
			User user = new User();
			map.addAttribute("userForm",user);
			return "registrationPage";
		}
		return viewPage;
	}
	
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public String saveUser(@Validated @ModelAttribute("userForm") User user,BindingResult result,ModelMap map){
		logger.info("Inside saveUser() UserRegister Controller ");
		String viewPage="";
		if(result.hasErrors()) {
			viewPage="registrationPage";
		}
		else {
			if(userService.checkUserByUserName(user.getUserName())!=null)
			{		
				map.addAttribute("Msg","User Name already in use. Please select a different User Name");
				map.addAttribute("colorMsg","red");
				viewPage="registrationPage";
			}
			else if(!user.getUserPassword().equals(user.getConfirmPassword()))
			{
				map.addAttribute("Msg","Passwords do not match!");
				map.addAttribute("colorMsg","red");
				viewPage="registrationPage";
			}
			else {
				userService.saveUser(user);
				map.addAttribute("Msg","You are successfully registered. Please Login now");
				map.addAttribute("colorMsg","green");
				viewPage="loginPage";
			}
		}
		return viewPage;
	}
	
	
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
