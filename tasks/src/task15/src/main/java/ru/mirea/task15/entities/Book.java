package ru.mirea.task15.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	@SequenceGenerator(name = "books_sequence", sequenceName = "books_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_sequence")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "creation_date")
	private String creationDate;

	@Override
	public String toString() {
		return "Book{" +
				"name='" + name + '\'' +
				", creationDate='" + creationDate + '\'' +
				'}';
	}
}
