package com.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.LoginDAO;
import com.stock.model.User;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDAO;
	
	public void registerUser(User user) {
		 loginDAO.registerUser(user);
	}

	public User validateUser(String uname, String password) {
		User user=loginDAO.validateUser(uname, password);
		return user;
	}

}
