package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BootController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/addAlien")
	public ModelAndView addAlien( Alien alien ) {
		repo.save(alien);
		ModelAndView ms = new ModelAndView();
		ms.setViewName("home");
		return ms;
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid ) {
		ModelAndView mv = new ModelAndView();
		Alien alien = repo.findById(aid).orElse(new Alien());
		System.out.println(alien);
		mv.addObject("obj", alien);
		mv.setViewName("showAlien");
		return mv;
	}
	
	@RequestMapping("/deleteAlien")
	public ModelAndView deleteAlien(@RequestParam int aid ) {
		ModelAndView mv = new ModelAndView();
		Alien alien = repo.findById(aid).orElse(new Alien());
		repo.delete(alien);
		mv.setViewName("home");
		return mv;
	}
	
	
	@RequestMapping("/editAlien")
	public ModelAndView editAlien( @RequestParam int aid ) {
		ModelAndView mv = new ModelAndView();
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject("obj", alien);
		mv.setViewName("edit");
		return mv;
	}
	
	@RequestMapping("/storeAlien")
	public ModelAndView storeAlien( Alien alien ) {
		ModelAndView mv = new ModelAndView();
		repo.save(alien);
		mv.setViewName("home");
		return mv;
	}
	
	
	
	
	
	
}




