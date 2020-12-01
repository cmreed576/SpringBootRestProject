package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.spring.exception.IncorrectUserType;

@Entity
public class User {
	
	@Id
	private String username;
	private String password;
	@Column(nullable = false)
	private String type;
	
	
	public User() { }

	public User(String username, String password, String usrtype) throws IncorrectUserType {
		this.username = username;
		this.password = password;
		this.setType(usrtype);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String usrtype) throws IncorrectUserType {
		if(usrtype.equals("admin") || usrtype.equals("customer")) {
			this.type = usrtype;
		}
		else {
			throw new IncorrectUserType();
		}

	}
	
	
}