package ru.mirea.task22.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.task22.entities.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findAllByName(String name);
	List<Book> findAllByCreationDate(String name);
	List<Book> findAllByAuthorId(Long authorId);
}
