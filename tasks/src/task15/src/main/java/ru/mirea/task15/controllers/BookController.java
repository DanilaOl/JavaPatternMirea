package ru.mirea.task15.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task15.entities.Book;
import ru.mirea.task15.services.BookService;

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
	public boolean deleteBook(Long id) {
		int prevSize = bookService.getBooks().size();
		bookService.deleteBookById(id);
		return bookService.getBooks().size() != prevSize;
	}
}
