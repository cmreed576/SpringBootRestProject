package com.spring.exception;

public class UserNotFound extends Exception{
	@Override 
	public String getMessage() {
		return "User not found";
	}
}