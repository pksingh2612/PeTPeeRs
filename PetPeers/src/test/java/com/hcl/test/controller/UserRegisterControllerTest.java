package com.hcl.test.controller;

import static org.mockito.Mockito.verifyZeroInteractions;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.InstanceOf;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.cs.controller.UserRegisterController;
import com.hcl.cs.model.User;
import com.hcl.cs.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:testConfig-servlet.xml"})
@WebAppConfiguration
public class UserRegisterControllerTest {
	
	@InjectMocks
	UserRegisterController userRegisterController;
	
	@Mock
	UserService userService;
	
	private MockMvc mockMvc;
	
	@Before 
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(userRegisterController).build();
	}
	
	@Test
	public void testRegister() throws Exception {
		mockMvc.perform(get("/register"))
		.andExpect(status().isOk())
		.andExpect(view().name("registrationPage"))
		.andExpect(model().attribute("userForm",new InstanceOf(User.class)));
         verifyZeroInteractions(userService);
	}
	
	@Test
	public void testSaveUser() throws Exception{
		mockMvc.perform( post("/saveUser")
						.param("userName","Ramesh")
						.param("userPassword","ramesh"))
		                .andExpect(status().is2xxSuccessful())
		                .andExpect(view().name("loginPage"))
		                .andExpect(model().attribute("userForm",new InstanceOf(User.class)))
		                .andExpect(model().attribute("userForm",hasProperty("userName",is("Ramesh"))))
		                .andExpect(model().attribute("userForm",hasProperty("userPassword",is("ramesh"))));
		
		ArgumentCaptor<User> argCap=ArgumentCaptor.forClass(User.class);
		Mockito.verify(userService).saveUser(argCap.capture());
		assertEquals("Ramesh",argCap.getValue().getUserName());
	}

}
