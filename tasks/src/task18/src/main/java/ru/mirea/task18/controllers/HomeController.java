package ru.mirea.task18.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping(value = "/home")
	public String getHomePage() {
		return "home";
	}
}
