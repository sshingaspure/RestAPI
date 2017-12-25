package com.service;

import com.model.User;

public interface LoginService {
	public User validateLogin(String username, String password);
	public void registerUser(User user);
	
}
