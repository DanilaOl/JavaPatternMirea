package ru.mirea.task14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.task14.entities.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class AuthorController {
	private ArrayList<Author> authorsList = new ArrayList<>();

	public static <T> ArrayList<T> getArrayListFromStream(Stream<T> stream) {
		List<T> list = stream.collect(Collectors.toList());
		return new ArrayList<>(list);
	}

	@GetMapping(value = "/get_authors")
	@ResponseBody
	public Object[] getAuthors() {
		return authorsList.toArray();
	}

	@PostMapping(value = "/add_author")
	@ResponseBody
	public String addAuthor(@RequestParam("firstName") String firstName,
	                        @RequestParam("lastName") String lastName,
	                        @RequestParam("middleName") String middleName,
	                        @RequestParam("birthDate") String birthDate) {
		Author author = new Author(firstName, lastName, middleName, birthDate);
		authorsList.add(author);
		return author.toString();
	}

	@DeleteMapping(value = "/delete_author")
	public boolean deleteAuthor(@RequestParam("firstName") String firstName,
	                            @RequestParam("lastName") String lastName,
	                            @RequestParam("middleName") String middleName,
	                            @RequestParam("birthDate") String birthDate) {
		int prevSize = authorsList.size();
		authorsList = getArrayListFromStream(authorsList.stream()
				.filter(author -> !(author.getFirstName().equals(firstName) &&
						author.getLastName().equals(lastName) &&
						author.getMiddleName().equals(middleName) &&
						author.getBirthDate().equals(birthDate))));

		return authorsList.size() != prevSize;
	}
}
