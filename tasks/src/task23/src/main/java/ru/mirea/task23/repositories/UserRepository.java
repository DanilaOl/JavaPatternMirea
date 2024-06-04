package ru.mirea.task23.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.task23.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByLogin(String login);
}
