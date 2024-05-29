package ru.mirea.task14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task14.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class BookController {
	private ArrayList<Book> booksList = new ArrayList<>();

	public static <T> ArrayList<T> getArrayListFromStream(Stream<T> stream) {
		List<T> list = stream.collect(Collectors.toList());

		return new ArrayList<T>(list);
	}

	@GetMapping(value = "/get_books")
	@ResponseBody
	public Object[] getBooks() {
		return booksList.toArray();
	}

	@PostMapping(value = "/add_book")
	public String addBook(@RequestParam("name") String name, @RequestParam("creationDate") String creationDate) {
		Book book = new Book(name, creationDate);
		booksList.add(book);
		return book.toString();
	}

	@DeleteMapping(value = "/delete_book")
	public boolean deleteBook(@RequestParam("name") String name, @RequestParam("creationDate") String creationDate) {
		int prevSize = booksList.size();
		booksList = getArrayListFromStream(booksList.stream()
				.filter(book -> !(book.getName().equals(name) &&
						book.getCreationDate().equals(creationDate))));

		return booksList.size() != prevSize;
	}
}
