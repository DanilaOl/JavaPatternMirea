package ru.mirea.task22.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.task22.entities.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	List<Author> findAllByFirstName(String firstName);
	List<Author> findAllByLastName(String lastName);
	List<Author> findAllByMiddleName(String middleName);
	List<Author> findAllByBirthDate(String birthDate);
}
