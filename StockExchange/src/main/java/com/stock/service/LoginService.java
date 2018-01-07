package com.stock.service;

import com.stock.model.User;

public interface LoginService {
	void registerUser(User user);
	User validateUser(String uname, String password);
}
