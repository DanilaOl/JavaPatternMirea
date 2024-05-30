package ru.mirea.task17.services;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mirea.task17.entities.Author;
import ru.mirea.task17.entities.Book;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookService {
	private final SessionFactory sessionFactory;
	private Session session;

	@Autowired
	AuthorService authorService;

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

	public Author getAuthor(Long bookId) {
		var transaction = session.beginTransaction();
		Book book = session.createQuery("select book from Book book where book.id = :id", Book.class)
				.setParameter("id", bookId).getSingleResult();
		Author author = authorService.getAuthorById(book.getAuthorId());
		transaction.commit();
		return author;
	}

	public <T> List<Book> getBooksFiltered(String attr, T value) {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);

		Predicate predicate = criteriaBuilder.equal(root.get(attr), value);
		query.select(root).where(predicate);

		return session.createQuery(query).getResultList();
	}
}
