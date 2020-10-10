package security.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@GetMapping("/")
	public String home() {
		return "WELCOME";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "WELCOME ADMIN";
	}
	
	@GetMapping("/user")
	public String user() {
		return "WELCOME USER";
	}
	
	

}
