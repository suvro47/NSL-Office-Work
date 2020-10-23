package com.example.demo.controllers;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepo;

@RestController
public class AppController {
	
	@Autowired
	UserRepo repo;
	@Autowired
	EntityManager em;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	
	// for saving the requested data into db.
	@RequestMapping("/addUser")
	public ModelAndView addUser(User var) {
		
		/// need to save the state on db
		repo.save(var);
		// return the home page 
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", var);
		System.out.println(var);
		mv.setViewName("home");
		return mv;	
	}
	
	@RequestMapping("/getUser")
	public ModelAndView getUser(@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		User user = repo.findById(id).orElse( new User());
		mv.addObject("obj", user);
		mv.setViewName("showUser");
		return mv;
	}
	
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		User user = repo.findById(id).orElse( new User());
	    repo.delete(user);
		mv.addObject("obj", user);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/editUser")
	public ModelAndView editUser( @RequestParam int id ) {
		ModelAndView mv = new ModelAndView();
		User user = em.find( User.class, id);
		mv.addObject("obj", user);
		mv.setViewName("edit");
		return mv;
	}
	
	@RequestMapping("/storeUser")
	public ModelAndView storeUser(User var) {
		
		/// need to save the state on db
		repo.save(var);
		// return the home page 
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", var);
		System.out.println(var);
		mv.setViewName("home");
		return mv;	
	}
	
	
	
}









