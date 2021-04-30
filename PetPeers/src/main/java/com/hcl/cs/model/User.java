package com.hcl.cs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
public class User {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USERID")
	private long userId;
	
	@NotEmpty
	@Column(name="USERNAME",unique=true)
	private String userName;

	@NotEmpty
	@Column(name="PASSWORD")
	private String userPassword;
	
	@Transient
	private String confirmPassword;
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval=true)
	private Set<Pet> pets = new HashSet<Pet>();

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	public User(String userName, String userPassword, String confirmPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.confirmPassword = confirmPassword;
	}

	public User() {
		super();
	}
	
	

}
