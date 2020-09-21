package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AppController {
	
	@RequestMapping("/home")
	public ModelAndView home( @RequestParam("name") String cname, HttpSession session ) // You can use #name directly as var_name , and in this case annotations is not required
	{
		session.setAttribute("name", cname); // data 
		return new ModelAndView ("home"); // home : view 
	}

}

/*

************************** More Convenient and Easy way to to Pass the data on Jsp ********************
Here Instead of using HttpSession , HttpServletRequest we will use ModelAndView object.

@RestController
public class AppController {
	
	@RequestMapping("/home")
	public ModelAndView home( @RequestParam("name") String cname )  /// HttpSession session not needed here
	{
	    ModelAndView mv = new ModelAndView();
		mv.addObject("name", cname);  /// (key, value) | data
		/// can add more object here 
		mv.setViewName("home");
		
		return mv;
	}
}

*/




