package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.UserDao;
import com.spring.exception.DuplicateUser;
import com.spring.exception.UserNotFound;
import com.spring.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao usrDao;
	
	@Override
	public void saveUser(User usr) throws DuplicateUser {
		if(!usrDao.searchUser(usr)) {
			usrDao.saveUser(usr);
		}else {
			throw new DuplicateUser();
		}
	}

	@Override
	public void updatePasswordOrUser(User usr) {
		usrDao.updatePasswordOrUser(usr);
	}

	@Override
	public User searchByName(String username) throws UserNotFound {
		return usrDao.searchByName(username);
	}

	@Override
	public List<User> searchByType(String usertype) {
		return usrDao.searchByType(usertype);
	}

	@Override
	public void deleteUser(User usr) {
		usrDao.deleteUser(usr);
	}

}