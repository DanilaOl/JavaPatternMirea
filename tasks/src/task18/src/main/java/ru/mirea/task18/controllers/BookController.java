package ru.mirea.task18.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task18.entities.Book;
import ru.mirea.task18.entities.DTO.AuthorDTO;
import ru.mirea.task18.services.BookService;

import java.util.List;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping(value = "/get_books")
	@ResponseBody
	public List<Book> getBooks() {
		return bookService.getBooks();
	}

	@PostMapping(value = "/add_book")
	@ResponseBody
	public String addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return book.toString();
	}

	@DeleteMapping(value = "/delete_book")
	@ResponseBody
	public boolean deleteBook(@RequestParam(name = "id") Long id) {
		int prevSize = bookService.getBooks().size();
		bookService.deleteBookById(id);
		return bookService.getBooks().size() != prevSize;
	}

	@GetMapping("/get_books/{bookId}/author")
	@ResponseBody
	public AuthorDTO getAuthorByBookId(@PathVariable Long bookId) {
		return bookService.getAuthorByBookId(bookId);
	}

	@GetMapping("/get_books/name/{name}")
	@ResponseBody
	public List<Book> getBooksByName(@PathVariable String name) {
		return bookService.getBooksByName(name);
	}

	@GetMapping("/get_books/date/{date}")
	@ResponseBody
	public List<Book> getBooksByDate(@PathVariable String date) {
		return bookService.getBooksByCreationDate(date);
	}

	@GetMapping("/get_books/author_id/{author_id}")
	@ResponseBody
	public List<Book> getBooksByName(@PathVariable Long author_id) {
		return bookService.getBooksByAuthorId(author_id);
	}
}
