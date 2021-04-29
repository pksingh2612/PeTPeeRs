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

import com.hcl.cs.controller.UserRegisterController;
import com.hcl.cs.model.User;
import com.hcl.cs.service.UserService;

import org.mockito.internal.matchers.InstanceOf;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:testConfig-servlet.xml"})
@WebAppConfiguration
public class UserRegisterControllerTest {
	
	Logger logger = Logger.getLogger(UserRegisterControllerTest.class);
	
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
    	
    	logger.info("Inside testRegister() user login test controller ");
        mockMvc.perform(get("/register"))
		        .andExpect(status().isOk())
		        .andExpect(view().name("registrationPage"))
		        .andExpect(model().attribute("userForm",new InstanceOf(User.class)));
		verifyZeroInteractions(userService);
    }
    
    @Test
    public void testSaveUser() throws Exception {
    	
    	logger.info("Inside testSaveUser() user login test controller ");
    	
        mockMvc.perform(post("/saveUser")
                        .param("userName","PK")
                        .param("userPassword","123")
        				.param("confirmPassword","123"))
                        .andExpect(status().is2xxSuccessful())
                        .andExpect(view().name("loginPage"))
                        .andExpect(model().attribute("userForm",new InstanceOf(User.class)))
                        .andExpect(model().attribute("userForm",hasProperty("userName",is("PK"))))
                        .andExpect(model().attribute("userForm",hasProperty("userPassword",is("123"))))
                        .andExpect(model().attribute("userForm",hasProperty("confirmPassword",is("123"))));
        
        ArgumentCaptor<User> argCap=ArgumentCaptor.forClass(User.class);
        Mockito.verify(userService).saveUser(argCap.capture());
        assertEquals("PK",argCap.getValue().getUserName());
                        
    }
}
