package com.hcl.cs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.cs.dao.UserDAO;
import com.hcl.cs.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

}
