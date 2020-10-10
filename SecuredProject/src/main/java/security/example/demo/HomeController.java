package security.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "WELCOME";
	}
	
	@GetMapping("/user")
	public String admin() {
		return "WELCOME USER";
	}
	
	@GetMapping("/admin")
	public String user() {
		return "WELCOME ADMIN";
	}

}
