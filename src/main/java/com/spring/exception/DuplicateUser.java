package com.spring.exception;

public class DuplicateUser extends Exception{
	@Override 
	public String getMessage() {
		return "Error - User already exists";
	}
}
