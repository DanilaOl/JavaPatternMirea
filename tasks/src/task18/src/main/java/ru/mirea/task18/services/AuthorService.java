package ru.mirea.task18.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.task18.entities.Author;
import ru.mirea.task18.repositories.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
	@Autowired
	private final AuthorRepository authorRepository;

	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	public void addAuthor(Author author) {
		authorRepository.save(author);
	}

	public void deleteAuthorById(Long id) {
		authorRepository.deleteById(id);
	}

	public List<Author> getAuthorsByFirstName(String firstName) {
		return authorRepository.findAllByFirstName(firstName);
	}

	public List<Author> getAuthorsByLastName(String lastName) {
		return authorRepository.findAllByLastName(lastName);
	}

	public List<Author> getAuthorsByMiddleName(String middleName) {
		return authorRepository.findAllByMiddleName(middleName);
	}

	public List<Author> getAuthorsByBirthDate(String birthDate) {
		return authorRepository.findAllByBirthDate(birthDate);
	}
}
