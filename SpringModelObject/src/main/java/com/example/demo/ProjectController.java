package com.example.demo;

//import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



/*
    If the client pass only one state/attribute 
    
@RestController
public class ProjectController {
	
	@RequestMapping("/home")
	public ModelAndView index( HttpServletRequest req )
	{
		String name = req.getParameter("name");
		System.out.println("Hi! " + name);
		
		// passing the data in jsp
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.setViewName("home");
		
		return mv;
	}

}
*/

// Handling multiple attribute/object

@RestController
public class ProjectController {
	
	@RequestMapping("/home")
	public ModelAndView index( Alien alien )
	{
		//String name = req.getParameter("name");
		//System.out.println("Hi! " + name);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		mv.setViewName("home");
		return mv;
	}
	

}

