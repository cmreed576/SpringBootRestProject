package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.DuplicateUser;
import com.spring.exception.UserNotFound;
import com.spring.model.User;
import com.spring.service.UserService;
@RestController
@RequestMapping("/user-management")
public class HomeController {

	@Autowired
	UserService usrService;
	
	@GetMapping("/")
	public String userHomePage() { 
		return "Welcome to Spring Boot Project";
	}
	
	@PostMapping(value="/addUser") 
	public void saveUser(@RequestBody User usr) {
		try {
			usrService.saveUser(usr);
		} catch (DuplicateUser e) {
			System.out.println(e);
		}
	}    
	
	@PostMapping("/update/user")
	public String updatePasswordOrUser(@RequestBody User usr) {
		usrService.updatePasswordOrUser(usr);
		return "user/password updated";
	}
	
	@GetMapping("/search/user/{username}")
	public User searchByName(@PathVariable("username") String username) throws UserNotFound{
			User userByName = usrService.searchByName(username);
			return userByName;
	}
	
	@GetMapping("/find/user/by/{usertype}")
	public List<User> searchByType(@PathVariable("usertype") String usertype){
		return usrService.searchByType(usertype);
	}
	
	@DeleteMapping
	public String deleteUser(@RequestBody User usr) {
		usrService.deleteUser(usr);
		return "user deleted";
	}
}
