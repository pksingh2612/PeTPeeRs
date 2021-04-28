package com.hcl.cs.dao;

import com.hcl.cs.model.User;

public interface UserDAO {
	
	public void saveUser(User user);
	
	public User authenticateUser(String userName,String userPassword);

}
