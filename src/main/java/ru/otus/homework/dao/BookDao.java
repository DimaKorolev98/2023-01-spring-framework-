package ru.otus.homework.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookDao implements LibDao<Book> {
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    @PersistenceContext
    private final EntityManager entityManager;


    public BookDao(AuthorDao authorDao, GenreDao genreDao, EntityManager entityManager) {
        this.authorDao = authorDao;
        this.genreDao = genreDao;
        this.entityManager = entityManager;
    }

    @Override
    public Book save(Book book) {

        if (book.getId() == null) {
            entityManager.persist(book);
        } else {
            entityManager.merge(book);
        }
        return book;
    }

    @Override
    public void delete(Book book) {
        entityManager.remove(book);
    }


    @Override
    public List<Book> getAll() {
        Session session = (Session)entityManager.unwrap(Session.class);
        session.close();
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    public Book findByName(String title) {
        var query = entityManager.createQuery("select b from Book b where b.title = :title", Book.class);
        query.setParameter("title", title);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public void addBook(String title, String authorName, String genreName) {
        Book book = new Book();
        book.setTitle(title);
        var author = authorDao.findByName(authorName);
        if (author == null) {
            author = authorDao.save(new Author(authorName));
        }
        book.setAuthor(author);

        var genre = genreDao.findByName(genreName);
        if (genre == null) {
            genre = genreDao.save(new Genre(genreName));
        }
        book.setGenre(genre);
        save(book);
    }
}
