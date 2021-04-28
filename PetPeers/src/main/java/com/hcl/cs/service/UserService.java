package com.hcl.cs.service;

import com.hcl.cs.model.User;

public interface UserService {
	public void saveUser(User user);
	
	public User authenticateUser(String userName,String userPassword);
	public User checkUserByUserName(String userName);
}
