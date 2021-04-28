package com.hcl.test.dao;


import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hcl.cs.dao.UserDAO;
import com.hcl.cs.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:testConfig-servlet.xml"})
@WebAppConfiguration
public class UserDAOTest {
	
	@Autowired
	UserDAO userDao;
	
	@Test
	@Ignore
	public void testSaveUserAndCheckUserByUserName() {
		User user = new User("Ayush","123456","123456");
		userDao.saveUser(user);
		
		User foundUser = userDao.checkUserByUserName("Ayush");
		assertEquals(foundUser.getUserName(),user.getUserName());
	}
	
	@Test
	//@Ignore
	public void testAuthenticateUser() {
		User foundUser = userDao.authenticateUser("Ayush","123456");
		assertEquals(foundUser.getUserName(),"Ayush");
		assertEquals(foundUser.getUserPassword(),"123456");
	}
	
	
}
