package ru.mirea.task20.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.task20.entities.DTO.AuthorDTO;
import ru.mirea.task20.entities.DTO.BookDTO;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
	@Id
	@SequenceGenerator(name = "authors_sequence", sequenceName = "authors_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authors_sequence")
	private Long id;

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "birth_date")
	private String birthDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
	private List<Book> books = new ArrayList<>();

	@Override
	public String toString() {
		return "Author{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", middleName='" + middleName + '\'' +
				", birthDate='" + birthDate + '\'' +
				", books=" + books +
				'}';
	}

	public AuthorDTO makeDTO() {
		List<BookDTO> bookDTOList = books.stream().map(Book::makeDTO).toList();
		return new AuthorDTO(id, firstName, lastName, middleName, birthDate, bookDTOList);
	}
}
