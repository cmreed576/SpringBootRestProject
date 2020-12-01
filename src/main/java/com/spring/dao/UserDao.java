package com.spring.dao;

import java.util.List;

import com.spring.exception.UserNotFound;
import com.spring.model.User;

public interface UserDao {
	
	public void saveUser(User usr);
	public void updatePasswordOrUser(User usr);
	public User searchByName(String username) throws UserNotFound;
	public List<User> searchByType(String usrType);
	public void deleteUser(User usr);
	boolean searchUser(User usr);
	
}
