package com.hcl.test.controller;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.apache.log4j.Logger;

import com.hcl.cs.controller.MainController;
import com.hcl.cs.model.User;
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
    
    @Test
    public void testHome() throws Exception {
    	logger.info("Inside testHome() pet test controller ");
        mockMvc.perform(get("/home"))
	        .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/login"));
    }
    
//    @Test
//    public void testAddPet() throws Exception {
//    	logger.info("Inside testAddPet() pet test controller ");
//        mockMvc.perform(post("/savePet")
//                        .param("petName","Tom")
//                        .param("petAge","3")
//        				.param("petPlace","Mau"))
////                        .andExpect(status().is2xxSuccessful())
//                        .andExpect(status().is3xxRedirection())
//        	            .andExpect(view().name("redirect:/login"))
//                        .andExpect(model().attribute("petForm",new InstanceOf(Pet.class)))
//                        .andExpect(model().attribute("petForm",hasProperty("petName",is("Tom"))))
//                        .andExpect(model().attribute("petForm",hasProperty("petAge",is(3))))
//                        .andExpect(model().attribute("petForm",hasProperty("petPlace",is("Mau"))));
//        
//        ArgumentCaptor<Pet> argCap=ArgumentCaptor.forClass(Pet.class);
//        Mockito.verify(petService).savePet(argCap.capture());
//        assertEquals("Tom",argCap.getValue().getPetName());
//                        
//    }
    
}
