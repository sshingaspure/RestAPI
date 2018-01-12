package com.stock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stock.model.User;
import com.stock.service.LoginService;
import com.stock.utility.Encryption;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexPage(ModelMap model) {
		model.addAttribute("message", "Hello, Welcome to Stock Exchange!!");
		return "index";

	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signInPage() {
		return new ModelAndView("signin");

	}
	
	@RequestMapping(value = "/validate")
	public ModelAndView validateUser(HttpServletRequest request,HttpServletResponse res,RedirectAttributes redirectAttributes) {
		String uname=request.getParameter("uname");
		String password=request.getParameter("passwd");
		User user=loginService.validateUser(uname, Encryption.encrypt(password));
		
		if (user==null) {
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("message", "Invalid Username or Password");
			modelAndView.setViewName("signin");
			return modelAndView; 
		}else {
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("user", user);
			modelAndView.setViewName("welcomePage");
			return modelAndView; 
		}
	
	/*	if (user==null) {
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("message", "Invalid Username or Password");
			modelAndView.setViewName("signin");
			return modelAndView; 
		}else {
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("user", user);
			modelAndView.setViewName("redirect:/application/homePage");
			return modelAndView; 
		}*/
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signUpPage() {
		return new ModelAndView("signup", "command", new User());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("SpringWeb") User user) {
		user.setPassword(Encryption.encrypt(user.getPassword()));
		loginService.registerUser(user);
		return "signin";
	}
	
	
}
