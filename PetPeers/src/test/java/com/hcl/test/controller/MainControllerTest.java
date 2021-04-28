package com.hcl.test.controller;

import static org.mockito.Mockito.verifyZeroInteractions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.InstanceOf;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.cs.controller.MainController;
import com.hcl.cs.model.User;
import com.hcl.cs.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:testConfig-servlet.xml"})
@WebAppConfiguration
public class MainControllerTest {
	
	@InjectMocks
	MainController mainController;
	
	@Mock
	UserService userService;
	
	private MockMvc mockMvc;
	
	@Before 
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(mainController).build();
	}
	
	@Test
	public void testIndex() throws Exception{
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("redirect:/login"));
         verifyZeroInteractions(userService);
	}
	
	@Test
	public void testLogout() throws Exception{
		mockMvc.perform(get("/logout"))
		.andExpect(status().isOk())
		.andExpect(view().name("loginPage"));
         verifyZeroInteractions(userService);
	}

}
