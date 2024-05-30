package ru.mirea.task17.services;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.mirea.task17.entities.Author;

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

	public Author getAuthorById(Long authorId) {
		var transaction = session.beginTransaction();
		Author author = session.createQuery("select author from Author author where author.id = :id", Author.class)
				.setParameter("id", authorId)
				.getSingleResult();
		transaction.commit();
		return author;
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

	public <T> List<Author> getAuthorFiltered(String attr, T value) {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Author> query = criteriaBuilder.createQuery(Author.class);
		Root<Author> root = query.from(Author.class);
		Predicate predicate = criteriaBuilder.equal(root.get(attr), value);

		query.select(root).where(predicate);
		return session.createQuery(query).getResultList();
	}
}
