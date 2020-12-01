package com.spring.exception;

public class IncorrectUserType extends Exception{
	
	@Override 
	public String getMessage() {
		return "Enter valid type of user: (admin,customer)";
	}
}