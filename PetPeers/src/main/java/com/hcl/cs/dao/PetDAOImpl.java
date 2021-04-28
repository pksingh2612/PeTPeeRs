package com.hcl.cs.dao;

import com.hcl.cs.model.Pet;
import com.hcl.cs.model.User;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PetDAOImpl implements PetDAO{
 	
	@Autowired
	private SessionFactory sessionFactory;
	
	Logger logger = Logger.getLogger(PetDAOImpl.class);
	
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
	
	@Override
	public List<Pet> getMyPet(long userId){
		logger.info("Inside getMyPet() dao");
		Query q=sessionFactory.getCurrentSession().createQuery("select p from Pet p where p.user.userId=?");
		q.setParameter(0, userId);		
		List plist=q.list();
		return plist;
	}
	
	@Override
	public void buyPet(long userId,long petId) {
		logger.info("Inside buyPet() dao");
		Query q=sessionFactory.getCurrentSession().createQuery("update Pet pt set pt.user.userId=? where pt.petId=?");
		q.setParameter(0, userId);
  		q.setParameter(1, petId);
  		q.executeUpdate();
	}
	

}
