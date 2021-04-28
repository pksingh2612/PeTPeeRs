package com.hcl.cs.dao;

import org.hibernate.Query;
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

	@Override
	public User authenticateUser(String userName, String userPassword) {
		Query q=sessionfactory.getCurrentSession().createQuery("select u from User u where u.username=? and u.Password=?");
		q.setParameter(0, userName);
		q.setParameter(1, userPassword);
		User user = (User)q.uniqueResult();
		return user;
	}

}
