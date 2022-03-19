package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginDetails {
	@Id
	private String userName;
	private String password;
	
	public LoginDetails() {
		// TODO Auto-generated constructor stub
	}
	
	

	public LoginDetails(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}



	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
