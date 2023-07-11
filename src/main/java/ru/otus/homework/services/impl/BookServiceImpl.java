package ru.otus.homework.services.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.assertj.core.util.Lists;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.repositories.AuthorRepository;
import ru.otus.homework.repositories.BookRepository;
import ru.otus.homework.rest.dto.BookDto;
import ru.otus.homework.services.BookService;
import ru.otus.homework.domain.Book;
import ru.otus.homework.services.GenreService;

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

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")},
            fallbackMethod = "getEmptyBook")
    @Override
    public List<Book> findAll() {
        //Для проверки
//        try {
//            Thread.sleep(7000);
//        }catch (Exception ignored){
//
//        }
        return Lists.newArrayList(bookRepository.findAll());
    }

    @Override
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Transactional
    public Book saveBook(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        Author author = authorDao.findByName(bookDto.getAuthor().getName());
        if (author == null) {
            author = authorDao.save(new Author(bookDto.getAuthor().getName()));
        }
        book.setAuthor(author);

        Genre genre = genreDao.findByName(bookDto.getGenre().getName());
        if (genre == null) {
            genre = genreDao.save(new Genre(bookDto.getGenre().getName()
            ));
        }
        book.setGenre(genre);
        bookRepository.save(book);
        return book;
    }
    public List<Book> getEmptyBook() {
        return Lists.newArrayList(new Book(0L, "NA", new Author(0L, "NA"), new Genre(0L, "NA")));
    }
}

