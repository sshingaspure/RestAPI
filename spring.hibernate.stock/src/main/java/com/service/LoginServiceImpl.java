package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginDao;
import com.model.User;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;

	public User validateLogin(String username, String password) {
		return loginDao.validateUser(username, password);
	}

	public void registerUser(User user) {
		loginDao.registerUser(user);
	}

}
