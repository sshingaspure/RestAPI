package com.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stock.model.User;

@Controller
@RequestMapping("/application")
public class AppController {

	@RequestMapping("/homePage")
	public ModelAndView homePage(Model input){
		ModelAndView modelAndView=new ModelAndView();
		
		User user=(User) input.asMap().get("");
		modelAndView.setViewName("welcomePage");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping("/test")
	public String test(){
		return "test";
		
	}
	
	
}
