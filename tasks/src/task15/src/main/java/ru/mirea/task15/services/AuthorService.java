package ru.mirea.task15.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.mirea.task15.entities.Author;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorService {
	private final SessionFactory sessionFactory;
	private Session session;

	@PostConstruct
	void init() {
		session = sessionFactory.openSession();
	}

	public List<Author> getAuthors() {
		return session.createQuery("from Author", Author.class).getResultList();
	}

	public void addAuthor(Author author) {
		var transaction = session.beginTransaction();
		session.saveOrUpdate(author);
		transaction.commit();
	}

	public void deleteAuthorById(Long id) {
		var transaction = session.beginTransaction();
		session.createQuery("delete from Author author where author.id = :id").setParameter("id", id).executeUpdate();
		transaction.commit();
	}
}
