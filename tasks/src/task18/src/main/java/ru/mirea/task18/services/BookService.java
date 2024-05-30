package ru.mirea.task18.services;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.mirea.task18.entities.Author;
import ru.mirea.task18.entities.Book;
import ru.mirea.task18.entities.DTO.AuthorDTO;
import ru.mirea.task18.entities.DTO.BookDTO;
import ru.mirea.task18.repositories.AuthorRepository;
import ru.mirea.task18.repositories.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
	@Autowired
	private final BookRepository bookRepository;
	@Autowired
	private final AuthorRepository authorRepository;

	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}

	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
	}

	public AuthorDTO getAuthorByBookId(Long bookId) {
		BookDTO bookDTO = bookRepository.getById(bookId).makeDTO();
		return authorRepository.getById(bookDTO.getAuthorId()).makeDTO();
	}

	public List<Book> getBooksByName(String name) {
		return bookRepository.findAllByName(name);
	}

	public List<Book> getBooksByCreationDate(String creationDate) {
		return bookRepository.findAllByCreationDate(creationDate);
	}

	public List<Book> getBooksByAuthorId(Long authorId) {
		return bookRepository.findAllByAuthorId(authorId);
	}


}
