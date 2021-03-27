package com.junit.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	

	@GetMapping("/welcome")
	public String welcome() {
		return "Controller Layer Testing";
	}
	
	
	@GetMapping("/home")
	public String home( @RequestParam String val ) {
		return "Hello " + val;
	}

}
