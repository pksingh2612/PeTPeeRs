package com.hcl.cs.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.cs.controller.UserRegisterController;
import com.hcl.cs.dao.UserDAO;
import com.hcl.cs.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public User authenticateUser(String userName, String userPassword) {
		User user= userDao.authenticateUser(userName,userPassword);
		return user;
	}
	
	@Override
	public User checkUserByUserName(String userName) {
		logger.info("Inside checkUserByUserName() service");
		User user= userDao.checkUserByUserName(userName);
		return user;
	}
	
}
