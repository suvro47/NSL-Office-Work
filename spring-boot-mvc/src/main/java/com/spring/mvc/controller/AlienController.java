package com.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.model.Alien;
import com.spring.mvc.repository.AlienRepo;

@Controller
public class AlienController {
	
	@Autowired
	private AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home";
	}
	
	@RequestMapping("/showAlien")
	public ModelAndView showAlien() {	
		List<Alien> allAlien = repo.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showAlien");
		mv.addObject("aliens", allAlien);
		return mv;
	}

}
