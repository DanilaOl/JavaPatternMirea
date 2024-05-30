package ru.mirea.task21.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.task21.entities.DTO.BookDTO;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", insertable = false, updatable = false)
	@JsonIgnore
	private Author author;

	@Column(name = "author_id")
	private Long authorId;

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", name='" + name + '\'' +
				", creationDate='" + creationDate + '\'' +
				", author=" + author +
				", authorId=" + authorId +
				'}';
	}

	public BookDTO makeDTO() {
		return new BookDTO(id, name, creationDate, authorId);
	}
}
