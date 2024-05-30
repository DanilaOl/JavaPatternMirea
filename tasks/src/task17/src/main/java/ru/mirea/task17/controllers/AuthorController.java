package ru.mirea.task17.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task17.entities.Author;
import ru.mirea.task17.services.AuthorService;

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
	public boolean deleteAuthor(@RequestParam(name = "id") Long id) {
		int prevSize = authorService.getAuthors().size();
		authorService.deleteAuthorById(id);
		return authorService.getAuthors().size() != prevSize;
	}

	@GetMapping("/get_authors/first_name/{firstName}")
	@ResponseBody
	public List<Author> getAuthorsByFirstName(@PathVariable String firstName) {
		return authorService.getAuthorFiltered("firstName", firstName);
	}

	@GetMapping("/get_authors/millde_name/{middleName}")
	@ResponseBody
	public List<Author> getAuthorsByMiddleName(@PathVariable String middleName) {
		return authorService.getAuthorFiltered("middleName", middleName);
	}

	@GetMapping("/get_authors/last_name/{lastName}")
	@ResponseBody
	public List<Author> getAuthorsByLastName(@PathVariable String lastName) {
		return authorService.getAuthorFiltered("lastName", lastName);
	}

	@GetMapping("/get_authors/birth_date/{birthDate}")
	@ResponseBody
	public List<Author> getAuthorsByBirthDate(@PathVariable String birthDate) {
		return authorService.getAuthorFiltered("birthDate", birthDate);
	}
}
