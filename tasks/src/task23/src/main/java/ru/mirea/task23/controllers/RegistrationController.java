package ru.mirea.task23.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.task23.entities.User;
import ru.mirea.task23.services.UserService;

@Controller
public class RegistrationController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestBody User user) {
		User myUser = userService.findByUsername(user.getLogin());
		if (myUser != null) {
			return String.format("user with name %s already exists", user.getLogin());
		}
		userService.create(user);
		return "ok";
	}
}
