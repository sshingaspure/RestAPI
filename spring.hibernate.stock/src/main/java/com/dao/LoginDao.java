package com.dao;

import com.model.User;

public interface LoginDao {
	
	User validateUser(String username, String password);
	void registerUser(User user);
}
