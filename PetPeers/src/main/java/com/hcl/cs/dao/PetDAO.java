package com.hcl.cs.dao;

import java.util.List;

import com.hcl.cs.model.Pet;

public interface PetDAO {
	public void savePet(Pet pet);
	public List<Pet> getAllPets();
	public List<Pet> getMyPet(long userId);
	public void buyPet(long userId,long petId);
	
}
