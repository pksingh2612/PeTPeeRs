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
import org.mockito.internal.matchers.InstanceOf;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasProperty;


import com.hcl.cs.controller.UserLoginController;
import com.hcl.cs.model.User;
import com.hcl.cs.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:testConfig-servlet.xml"})
@WebAppConfiguration
public class UserLoginControllerTest {
	
	Logger logger = Logger.getLogger(UserLoginControllerTest.class);
	
	@InjectMocks
    UserLoginController userLoginController;
    
    @Mock
    UserService userService;
    
    private MockMvc mockMvc;
    
    @Before 
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc=MockMvcBuilders.standaloneSetup(userLoginController).build();
    }
    
    @Test
    public void testLogin() throws Exception {
    	logger.info("Inside testLogin() user login test controller ");
        mockMvc.perform(get("/login"))
		        .andExpect(status().isOk())
		        .andExpect(view().name("loginPage"))
		        .andExpect(model().attribute("userForm",new InstanceOf(User.class)));
		verifyZeroInteractions(userService);
    }
    
    @Test
    public void testSaveEmployee() throws Exception {
    	logger.info("Inside testSaveEmployee() user login test controller ");
        mockMvc.perform(post("/authenticateUser")
                        .param("userName","PK")
                        .param("userPassword","123"))
                        .andExpect(status().is2xxSuccessful());
//                        .andExpect(view().name("homePage"))
//                        .andExpect(model().attribute("userForm",new InstanceOf(User.class)))
//                        .andExpect(model().attribute("userForm",hasProperty("userName",is("PK"))))
//                        .andExpect(model().attribute("userForm",hasProperty("userPassword",is("123"))));
//        
//        ArgumentCaptor<User> argCap=ArgumentCaptor.forClass(User.class);
//        Mockito.verify(userService).authenticateUser(argCap.capture());
//        assertEquals("Ramesh1",argCap.getValue().getName());
                        
    }
    
    
}
