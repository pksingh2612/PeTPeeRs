package com.hcl.cs.model;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.mapping.Set;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	@NotEmpty
	private String userName;
	@NotEmpty
	private String userPassword;
	@NotEmpty
	private String confirmPassword;
	private Set pets;
	public User(long userId, String userName, String userPassword, String confirmPassword, Set pets) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.confirmPassword = confirmPassword;
		this.pets = pets;
	}
	public User() {
		super();
	}
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
	public Set getPets() {
		return pets;
	}
	public void setPets(Set pets) {
		this.pets = pets;
	}

}
