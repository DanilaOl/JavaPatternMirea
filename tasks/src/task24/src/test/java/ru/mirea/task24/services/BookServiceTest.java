package ru.mirea.task24.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.task24.entities.Book;
import ru.mirea.task24.entities.DTO.BookDTO;
import ru.mirea.task24.repositories.AuthorRepository;
import ru.mirea.task24.repositories.BookRepository;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	@Mock
	private BookRepository bookRepository;
	@Mock
	private AuthorRepository authorRepository;
	@Captor
	ArgumentCaptor<Book> captor;

	@Test
	void getBooks() {
		Book book1 = new Book();
		book1.setName("testBook1");
		book1.setCreationDate("testDate1");
		Book book2 = new Book();
		book2.setName("testBook2");
		book2.setCreationDate("testDate2");
		Mockito.when(bookRepository.findAll()).thenReturn(List.of(book1, book2));
		BookService bookService = new BookService(bookRepository, authorRepository);
		Assertions.assertEquals(2, bookService.getBooks().size());
		Assertions.assertEquals("testBook1", bookService.getBooks().get(0).getName());
	}

	@Test
	void saveOrUpdate() {
		Book book3 = new Book();
		book3.setName("testBook3");
		book3.setCreationDate("testDate3");
		BookService bookService = new BookService(bookRepository, authorRepository);
		bookService.addBook(book3);
		Mockito.verify(bookRepository).save(captor.capture());
		Book captured = captor.getValue();
		Assertions.assertEquals("testBook3", captured.getName());
	}
}
