package com.hcl.test.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hcl.cs.dao.PetDAO;
import com.hcl.cs.model.Pet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:testConfig-servlet.xml"})
@WebAppConfiguration
public class PetDAOTest {
	@Autowired
	PetDAO petDao;
	
	@Test
	@Ignore
	public void testSavePet() {
		Pet pet = new Pet("Tom",3,"Lucknow");
		petDao.savePet(pet);
		
		List<Pet> petList = petDao.getAllPets();
		assertEquals(petList.size(),5);
	}
	
	@Test
	@Ignore
	public void testGetAllPets() {
		List<Pet> petList = petDao.getAllPets();
		assertEquals(petList.size(),5);
	}
	
	@Test
	@Ignore
	public void testGetMyPet() {
		List<Pet> myPetList = petDao.getMyPet(1);
		assertEquals(myPetList.size(),2);
	}
	
	@Test
	public void testBuyPet() {
		petDao.buyPet(1,5);
		
		List<Pet> myPetList = petDao.getMyPet(1);
		assertEquals(myPetList.size(),3);
	}
	
	
}
