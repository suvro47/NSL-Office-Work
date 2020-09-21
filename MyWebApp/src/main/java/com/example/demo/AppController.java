package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AppController {
	
	@RequestMapping("/home")
	public ModelAndView firstpage() {
		return new ModelAndView("home.jsp");
	}
}
