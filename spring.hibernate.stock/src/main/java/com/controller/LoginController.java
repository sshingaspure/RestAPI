package com.controller;

import com.model.User;
import com.service.LoginService;
import com.utility.Encryption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String indexPage(ModelMap model) {
		model.addAttribute("message","Hello, Welcome to Stock Exchange!!");
		return "index";
		
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public ModelAndView signInPage() {
		return new ModelAndView("signin", "user", new User());
		
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView signUpPage() {
		return new ModelAndView("signup", "command", new User());
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("SpringWeb")User user) {
		user.setPassword(Encryption.encrypt(user.getPassword()));
		loginService.registerUser(user);
		return "signin";
	}
}
