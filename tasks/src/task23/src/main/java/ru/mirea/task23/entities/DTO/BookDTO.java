package ru.mirea.task23.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookDTO {
	private Long id;
	private String name;
	private String creationDate;
	private Long authorId;
}
