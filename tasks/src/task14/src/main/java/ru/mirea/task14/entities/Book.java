package ru.mirea.task14.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
	private String name, creationDate;

	@Override
	public String toString() {
		return "Book{" +
				"name='" + name + '\'' +
				", creationDate='" + creationDate + '\'' +
				'}';
	}
}
