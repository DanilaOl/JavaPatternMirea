package ru.mirea.task15.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.mirea.task15.entities.Book;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookService {
	private final SessionFactory sessionFactory;
	private Session session;

	@PostConstruct
	void init() {
		session = sessionFactory.openSession();
	}

	public List<Book> getBooks() {
		return session.createQuery("from Book", Book.class).getResultList();
	}

	public void addBook(Book book) {
		var transaction = session.beginTransaction();
		session.saveOrUpdate(book);
		transaction.commit();
	}

	public void deleteBookById(Long id) {
		var transaction = session.beginTransaction();
		session.createQuery("delete from Book book where book.id = :id").setParameter("id", id).executeUpdate();
		transaction.commit();
	}
}
