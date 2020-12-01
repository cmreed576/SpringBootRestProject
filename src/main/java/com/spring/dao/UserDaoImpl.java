package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.exception.UserNotFound;
import com.spring.model.User;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {
	
	@Override
	public void saveUser(User usr) {
		getSession().save(usr);
	}

	@Override
	public void updatePasswordOrUser(User usr) {
		getSession().update(usr);
	}

	@Override
	public User searchByName(String username) throws UserNotFound {
		User byUserName = (User) getSession().createQuery("from User where username='"+username+"'").uniqueResult();
		if(byUserName==null) {
			throw new UserNotFound();
		}else {
			return byUserName;
		}
	}

	@Override
	public List<User> searchByType(String usertype) {
		List<User> byUserType = getSession().createQuery("from User where usertype='"+usertype+"'").list();
		return byUserType;
	}

	@Override
	public void deleteUser(User user) {
		getSession().delete(user);
	}
	
	@Override
	public boolean searchUser(User user) {
		List<User> isAvailable = getSession().createQuery("from User where username='"+ user.getUsername()+"'"+ "and password='"+user.getPassword()+"'"+"and usertype='"+user.getType()+"'").list();
		if(isAvailable.isEmpty()) {
			return false;
		}
		return true;
	}


}
