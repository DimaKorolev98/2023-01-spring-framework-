package ru.otus.homework.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.dao.AuthorDao;
import ru.otus.homework.dao.BookDao;
import ru.otus.homework.dao.CommentDao;
import ru.otus.homework.dao.GenreDao;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.domain.Genre;

import javax.transaction.Transactional;

@ShellComponent
public class BookCRUD {
    private final BookDao bookDao;
    Author author;
    Genre genre;

    public BookCRUD(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @ShellMethod
    @Transactional
    public void findAll() {
        System.out.println(bookDao.getAll());
    }

    @ShellMethod
    @Transactional
    public void addBook(String title, String authorName, String genreName) {
        bookDao.addBook(title, authorName, genreName);
    }

    @ShellMethod
    @Transactional
    public void deleteBook(String title) {
        bookDao.delete(bookDao.findByName(title));
    }
    @ShellMethod
    @Transactional
    public void findBook(String title) {
        System.out.println(bookDao.findByName(title));
    }
}
