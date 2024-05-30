package ru.mirea.task15.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task15.entities.Author;
import ru.mirea.task15.services.AuthorService;

import java.util.List;

@Controller
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@GetMapping(value = "/get_authors")
	@ResponseBody
	public List<Author> getAuthors() {
		return authorService.getAuthors();
	}

	@PostMapping(value = "/add_author")
	@ResponseBody
	public String addAuthor(@RequestBody Author author) {
		authorService.addAuthor(author);
		return author.toString();
	}

	@DeleteMapping(value = "/delete_author")
	@ResponseBody
	public boolean deleteAuthor(Long id) {
		int prevSize = authorService.getAuthors().size();
		authorService.deleteAuthorById(id);
		return authorService.getAuthors().size() != prevSize;
	}
}
