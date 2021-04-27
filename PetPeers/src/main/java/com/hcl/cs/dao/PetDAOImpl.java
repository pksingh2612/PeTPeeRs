package com.hcl.cs.dao;

import com.hcl.cs.model.Pet;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

@Repository
public class PetDAOImpl implements PetDAO{
    
	Logger logger = Logger.getLogger(PetDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void savePet(Pet pet) {
		logger.info("Inside savePet() dao");
		sessionFactory.getCurrentSession().save(pet);
	}
	
	@Override
	public List<Pet> getAllPets() {
		
		logger.info("Inside getAllPets() dao");
		
		Query q=sessionFactory.getCurrentSession().createQuery("select p from Pet p");
		List plist=q.list();
		return plist;
	}
	

}
