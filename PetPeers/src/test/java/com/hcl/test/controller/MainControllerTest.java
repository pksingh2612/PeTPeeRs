package com.hcl.test.controller;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Before;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.apache.log4j.Logger;

import com.hcl.cs.controller.MainController;
import com.hcl.cs.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:testConfig-servlet.xml"})
@WebAppConfiguration
public class MainControllerTest {
	
	Logger logger = Logger.getLogger(MainControllerTest.class);
	
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
    public void testIndex() throws Exception {
    	logger.info("Inside testIndex() main test controller ");	
    	
        mockMvc.perform(get("/"))
        				.andExpect(status().is3xxRedirection())
                        .andExpect(view().name("redirect:/login"));
    }
        
    @Test
    public void testLogout() throws Exception {
    	logger.info("Inside testLogout() main test controller ");
    	
        mockMvc.perform(get("/logout"))
        				.andExpect(status().is3xxRedirection())
                        .andExpect(view().name("redirect:/login"));
    }
    
}
