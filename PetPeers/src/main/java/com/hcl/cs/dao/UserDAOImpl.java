package com.hcl.cs.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.cs.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void saveUser(User user) {
		sessionfactory.getCurrentSession().save(user);
		
	}

}
