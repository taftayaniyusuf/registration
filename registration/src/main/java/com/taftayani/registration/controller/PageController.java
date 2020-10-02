package com.taftayani.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.taftayani.registration.model.User;

@Controller
public class PageController {

	@GetMapping("/registration")
	public String ShowRegistrarionPage(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "RegistrationPage";
	}
	@GetMapping("/login")
	public String ShowLoginPage() {
		return "LoginPage";
	}
}
