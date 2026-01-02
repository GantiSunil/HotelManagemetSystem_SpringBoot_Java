package com.sunil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UsersInfo {
	
	
	//private Integer id;
	@Id
	private String userName;
	
	private String roles;
	
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsersInfo(String userName, String roles, String password) {
		super();
		this.userName = userName;
		this.roles = roles;
		this.password = password;
	}

	public UsersInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UsersInfo [userName=" + userName + ", roles=" + roles + ", password=" + password + "]";
	}
	
	
	
	
	
	

}
