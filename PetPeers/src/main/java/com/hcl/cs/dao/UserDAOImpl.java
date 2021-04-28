package com.hcl.cs.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.cs.model.User;
import com.hcl.cs.service.UserServiceImpl;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	Logger logger = Logger.getLogger(UserDAOImpl.class); 
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void saveUser(User user) {
		logger.info("Inside saveUser() dao");
		sessionfactory.getCurrentSession().save(user);
	}

	@Override
	public User authenticateUser(String userName, String userPassword) {
		logger.info("Inside authenticateUser() dao");
		Query q=sessionfactory.getCurrentSession().createQuery("select u from User u where u.userName=? and u.userPassword=?");
		q.setParameter(0, userName);
		q.setParameter(1, userPassword);
		User user = (User)q.uniqueResult();
		return user;
	}
	
	@Override
	public User checkUserByUserName(String userName) {
		logger.info("Inside checkUserByUserName() dao");
		Query q=sessionfactory.getCurrentSession().createQuery("select u from User u where u.userName=?");
		q.setParameter(0, userName);
		User user = (User)q.uniqueResult();
		return user;
	}

}
