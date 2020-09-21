package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExampleController {
	
	@RequestMapping("/")
	public String index() {
		return "Web Server Response!";
	}
}


