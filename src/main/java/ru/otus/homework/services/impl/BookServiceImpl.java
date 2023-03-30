package ru.otus.homework.services.impl;

import org.assertj.core.util.Lists;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.repositories.AuthorRepository;
import ru.otus.homework.repositories.BookRepository;
import ru.otus.homework.services.AuthorService;
import ru.otus.homework.services.BookService;
import ru.otus.homework.domain.Book;
import ru.otus.homework.services.GenreService;

import javax.transaction.Transactional;
import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorDao;
    private final GenreService genreDao;
    SessionFactory sessionFactory;


    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorDao, GenreService genreDao) {
        this.bookRepository = bookRepository;
        this.authorDao = authorDao;
        this.genreDao = genreDao;

    }


    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }



    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }


    @Override
    public List<Book> findAll() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    @Override
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
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

        bookRepository.save(book);
    }
}

