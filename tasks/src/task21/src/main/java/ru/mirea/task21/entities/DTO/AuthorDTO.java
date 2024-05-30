package ru.mirea.task21.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AuthorDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String birthDate;
	private List<BookDTO> books;
}
