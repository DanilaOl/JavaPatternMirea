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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
