package com.hcl.test.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.apache.log4j.Logger;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.cs.controller.PetController;
import com.hcl.cs.model.Pet;
import com.hcl.cs.service.PetService;

import org.mockito.internal.matchers.InstanceOf;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:testConfig-servlet.xml"})
@WebAppConfiguration
public class PetControllerTest {
		
		Logger logger = Logger.getLogger(PetControllerTest.class);
		
	    @InjectMocks
	    PetController petController;
	    
	    @Mock
	    PetService petService;
	    
	    private MockMvc mockMvc;
	    
	    @Before 
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	        mockMvc=MockMvcBuilders.standaloneSetup(petController).build();
	    }
	    
	    @Test
	    public void testHome() throws Exception {
	    	logger.info("Inside testHome() pet test controller ");
	        mockMvc.perform(get("/home"))
		        .andExpect(status().is3xxRedirection())
	            .andExpect(view().name("redirect:/login"));
	    }
	    
//	    @Test
//	    public void testAddPet() throws Exception {
//	    	logger.info("Inside testAddPet() pet test controller ");
//	        mockMvc.perform(post("/savePet")
//	                        .param("petName","Tom")
//	                        .param("petAge","3")
//	        				.param("petPlace","Mau"))
////	                        .andExpect(status().is2xxSuccessful())
//	                        .andExpect(status().is3xxRedirection())
//	        	            .andExpect(view().name("redirect:/login"))
//	                        .andExpect(model().attribute("petForm",new InstanceOf(Pet.class)))
//	                        .andExpect(model().attribute("petForm",hasProperty("petName",is("Tom"))))
//	                        .andExpect(model().attribute("petForm",hasProperty("petAge",is(3))))
//	                        .andExpect(model().attribute("petForm",hasProperty("petPlace",is("Mau"))));
//	        
//	        ArgumentCaptor<Pet> argCap=ArgumentCaptor.forClass(Pet.class);
//	        Mockito.verify(petService).savePet(argCap.capture());
//	        assertEquals("Tom",argCap.getValue().getPetName());
//	                        
//	    }
	    
}
