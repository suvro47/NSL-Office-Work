package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String welcome() {
		return "home";
	}
	
	// receiving client data (requestParam url?parameter=value)  
	@RequestMapping("/hello")
	public ModelAndView receiveParameter( @RequestParam("name") String name ) {
		System.out.println("Hello! " + name);
		ModelAndView mv = new ModelAndView();
	    mv.addObject("name", name);
		mv.setViewName("hello");
		return mv;
	}
	
	// receiving client data (requestParam url?parameter=value&parameter=value&...)  
	@RequestMapping("/alien")
	public ModelAndView receiveObject( Alien alien ) {
		ModelAndView mv = new ModelAndView();
	    mv.addObject("alien", alien);
		mv.setViewName("alien");
		return mv;
	}
	
}
