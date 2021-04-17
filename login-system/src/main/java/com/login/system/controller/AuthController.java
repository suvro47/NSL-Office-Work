package com.login.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/")
	public String loginSuccess(Model model) {
		model.addAttribute("loginSuccess", true);
		return "login-status";
	}

	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login-status";
	}

	// Logout
	@RequestMapping("/logout-success")
	public String logoutSuccess() {
		return "login";
	}

}
