package ru.mirea.task24.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.task24.entities.Book;
import ru.mirea.task24.entities.DTO.AuthorDTO;
import ru.mirea.task24.entities.DTO.BookDTO;
import ru.mirea.task24.repositories.AuthorRepository;
import ru.mirea.task24.repositories.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
	@Autowired
	private final BookRepository bookRepository;
	@Autowired
	private final AuthorRepository authorRepository;

	@Transactional(readOnly = true)
	public List<Book> getBooks() {
		log.info("Find all books");
		return bookRepository.findAll();
	}

	@Transactional
	public void addBook(Book book) {
		log.info("Add book {}", book);
		bookRepository.save(book);
	}

	@Transactional
	public void deleteBookById(Long id) {
		log.info("Delete book by id {}", id);
		bookRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public AuthorDTO getAuthorByBookId(Long bookId) {
		log.info("Get author by book id {}", bookId);
		BookDTO bookDTO = bookRepository.getById(bookId).makeDTO();
		return authorRepository.getById(bookDTO.getAuthorId()).makeDTO();
	}

	@Transactional(readOnly = true)
	public List<Book> getBooksByName(String name) {
		log.info("Get books by name {}", name);
		return bookRepository.findAllByName(name);
	}

	@Transactional(readOnly = true)
	public List<Book> getBooksByCreationDate(String creationDate) {
		log.info("Get books by creation date {}", creationDate);
		return bookRepository.findAllByCreationDate(creationDate);
	}

	@Transactional(readOnly = true)
	public List<Book> getBooksByAuthorId(Long authorId) {
		log.info("Get books by author id {}", authorId);
		return bookRepository.findAllByAuthorId(authorId);
	}


}
