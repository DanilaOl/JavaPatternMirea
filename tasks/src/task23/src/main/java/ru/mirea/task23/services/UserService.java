package ru.mirea.task23.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mirea.task23.entities.User;
import ru.mirea.task23.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public User findByUsername(String username) {
		Optional<User> appUser = userRepository.findByLogin(username);
		if (appUser.isEmpty()) {
			return null;
		}
		return appUser.get();
	}

	public User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

		return userRepository.findByLogin(principal.getUsername()).orElseThrow(() -> new IllegalArgumentException("user not found"));
	}
}
