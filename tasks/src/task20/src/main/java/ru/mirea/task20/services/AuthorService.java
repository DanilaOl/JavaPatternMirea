package ru.mirea.task20.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.task20.entities.Author;
import ru.mirea.task20.repositories.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {
	@Autowired
	private final AuthorRepository authorRepository;

	public List<Author> getAuthors() {
		log.info("Find all authors");
		return authorRepository.findAll();
	}

	public void addAuthor(Author author) {
		log.info("Save author {}", author);
		authorRepository.save(author);
	}

	public void deleteAuthorById(Long id) {
		log.info("Delete author by id {}", id);
		authorRepository.deleteById(id);
	}

	public List<Author> getAuthorsByFirstName(String firstName) {
		log.info("Get authors by firstname {}", firstName);
		return authorRepository.findAllByFirstName(firstName);
	}

	public List<Author> getAuthorsByLastName(String lastName) {
		log.info("Get authors by lastname {}", lastName);
		return authorRepository.findAllByLastName(lastName);
	}

	public List<Author> getAuthorsByMiddleName(String middleName) {
		log.info("Get authors by middlename {}", middleName);
		return authorRepository.findAllByMiddleName(middleName);
	}

	public List<Author> getAuthorsByBirthDate(String birthDate) {
		log.info("Get authors by birthdate {}", birthDate);
		return authorRepository.findAllByBirthDate(birthDate);
	}
}
