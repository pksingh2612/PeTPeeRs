package com.hcl.cs.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.cs.dao.PetDAO;
import com.hcl.cs.model.Pet;

@Service
@Transactional
public class PetServiceImpl implements PetService {
	Logger logger = Logger.getLogger(PetServiceImpl.class);
	
	@Autowired 
	private PetDAO petDao;
	
	@Override
	public void savePet(Pet pet) {
		logger.info("Inside savePet() service");
		petDao.savePet(pet);
	}
	
	@Override
	public List<Pet> getAllPets(){
		logger.info("Inside getAllPets() service");
		List<Pet> empList = petDao.getAllPets();
		return empList;
	}
}
