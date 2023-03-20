package ru.otus.homework.Shell;

import org.springframework.context.annotation.Lazy;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.services.AuthorService;
import ru.otus.homework.services.BookService;
import ru.otus.homework.services.CommentService;
import ru.otus.homework.services.GenreService;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.services.impl.BookServiceImpl;

import javax.transaction.Transactional;

@ShellComponent
public class BookCRUD {
    private final BookService bookDao;

    public BookCRUD(BookService bookDao) {
        this.bookDao = bookDao;

    }

    @ShellMethod
    public void findAll() {
        System.out.println(bookDao.findAll());
    }

    @ShellMethod
    public void addBook(String title, String authorName, String genreName) {
        bookDao.addBook(title, authorName, genreName);
    }

    @ShellMethod
    public void deleteBook(String title) {
        bookDao.delete(bookDao.findByTitle(title));
    }
    @ShellMethod
    public void findBook(String title) {
        System.out.println(bookDao.findByTitle(title));
    }
}
