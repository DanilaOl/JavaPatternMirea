package ru.mirea.task24.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.task24.entities.Author;
import ru.mirea.task24.repositories.AuthorRepository;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
	@Mock
	private AuthorRepository authorRepository;
	@Captor
	ArgumentCaptor<Author> captor;

	@Test
	void getAuthors() {
		Author author1 = new Author();
		author1.setFirstName("testFName1");
		author1.setLastName("testLName1");
		author1.setMiddleName("testMName1");
		author1.setBirthDate("testDate1");
		Author author2 = new Author();
		author2.setFirstName("testFName2");
		author2.setLastName("testLName2");
		author2.setMiddleName("testMName2");
		author2.setBirthDate("testDate2");
		Mockito.when(authorRepository.findAll()).thenReturn(List.of(author1, author2));
		AuthorService authorService = new AuthorService(authorRepository);
		Assertions.assertEquals(2, authorService.getAuthors().size());
		Assertions.assertEquals("testFName1", authorService.getAuthors().get(0).getFirstName());
	}

	@Test
	void saveOrUpdate() {
		Author author3 = new Author();
		author3.setFirstName("testFName3");
		author3.setLastName("testLName3");
		author3.setMiddleName("testMName3");
		author3.setBirthDate("testDate3");
		AuthorService authorService = new AuthorService(authorRepository);
		authorService.addAuthor(author3);
		Mockito.verify(authorRepository).save(captor.capture());
		Author captured = captor.getValue();
		Assertions.assertEquals("testFName3", captured.getFirstName());
	}
}
