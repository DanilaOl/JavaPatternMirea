package ru.mirea.task20.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.task20.entities.Book;
import ru.mirea.task20.entities.DTO.AuthorDTO;
import ru.mirea.task20.entities.DTO.BookDTO;
import ru.mirea.task20.repositories.AuthorRepository;
import ru.mirea.task20.repositories.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
	@Autowired
	private final BookRepository bookRepository;
	@Autowired
	private final AuthorRepository authorRepository;

	public List<Book> getBooks() {
		log.info("Find all books");
		return bookRepository.findAll();
	}

	public void addBook(Book book) {
		log.info("Add book {}", book);
		bookRepository.save(book);
	}

	public void deleteBookById(Long id) {
		log.info("Delete book by id {}", id);
		bookRepository.deleteById(id);
	}

	public AuthorDTO getAuthorByBookId(Long bookId) {
		log.info("Get author by book id {}", bookId);
		BookDTO bookDTO = bookRepository.getById(bookId).makeDTO();
		return authorRepository.getById(bookDTO.getAuthorId()).makeDTO();
	}

	public List<Book> getBooksByName(String name) {
		log.info("Get books by name {}", name);
		return bookRepository.findAllByName(name);
	}

	public List<Book> getBooksByCreationDate(String creationDate) {
		log.info("Get books by creation date {}", creationDate);
		return bookRepository.findAllByCreationDate(creationDate);
	}

	public List<Book> getBooksByAuthorId(Long authorId) {
		log.info("Get books by author id {}", authorId);
		return bookRepository.findAllByAuthorId(authorId);
	}


}
