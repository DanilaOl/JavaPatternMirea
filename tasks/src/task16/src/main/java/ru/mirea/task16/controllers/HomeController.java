package ru.mirea.task16.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping(value = "/home")
	public String getHomePage() {
		return "home";
	}
}
