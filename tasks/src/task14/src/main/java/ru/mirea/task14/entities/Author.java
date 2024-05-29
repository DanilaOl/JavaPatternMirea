package ru.mirea.task14.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Author {
	private String firstName, lastName, middleName, birthDate;

	@Override
	public String toString() {
		return "Author{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", middleName='" + middleName + '\'' +
				", birthDate='" + birthDate + '\'' +
				'}';
	}
}
