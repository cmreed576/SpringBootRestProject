package com.spring.service;

import java.util.List;
import java.util.Optional;

import com.spring.exception.DuplicateUser;
import com.spring.exception.UserNotFound;
import com.spring.model.User;

public interface UserService {
	
	public void saveUser(User usr) throws DuplicateUser;
	public void updatePasswordOrUser(User usr);
	public User searchByName(String username) throws UserNotFound;
	public List<User> searchByType(String usertype);
	public void deleteUser(User usr);
}
