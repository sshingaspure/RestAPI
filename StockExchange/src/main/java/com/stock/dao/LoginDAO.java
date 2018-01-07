package com.stock.dao;

import com.stock.model.User;

public interface LoginDAO {
	
	void registerUser(User user);
	User validateUser(String uname, String password);
}
