package com.hcl.cs.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PET")
public class Pet {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="PETID")
	private long petId;
	
	@Column(name="PETNAME")
	private String petName;
	
	@Column(name="PETAGE")
	private int petAge;
	
	@Column(name="PETPLACE")
	private String petPlace;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="PETOWNERID")
    private User user;

	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public String getPetPlace() {
		return petPlace;
	}

	public void setPetPlace(String petPlace) {
		this.petPlace = petPlace;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}
