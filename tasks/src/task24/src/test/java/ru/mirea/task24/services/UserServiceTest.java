package ru.mirea.task24.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.mirea.task24.entities.User;
import ru.mirea.task24.repositories.UserRepository;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	private UserRepository userRepository;
	@Mock
	private PasswordEncoder passwordEncoder;
	@Captor
	ArgumentCaptor<User> captor;

	@Test
	void getUsers() {
		User user1 = new User();
		user1.setLogin("testLogin1");
		user1.setPassword("testPassword1");
		User user2 = new User();
		user2.setLogin("testLogin2");
		user2.setPassword("testPassword2");
		Mockito.when(userRepository.findAll()).thenReturn(List.of(user1, user2));
		UserService userService = new UserService(userRepository, passwordEncoder);
		Assertions.assertEquals(2, userService.getUsers().size());
		Assertions.assertEquals("testLogin1", userService.getUsers().get(0).getLogin());
	}
}
