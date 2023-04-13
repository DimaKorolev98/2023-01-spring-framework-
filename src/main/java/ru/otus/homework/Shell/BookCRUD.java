package ru.otus.homework.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.repositories.CommentRepository;
import ru.otus.homework.services.BookService;

import java.util.ArrayList;
import java.util.List;


@ShellComponent
public class BookCRUD {
    private final BookService bookService;

    public BookCRUD(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod
    public void findAllBooks() {
        System.out.println(bookService.findAll().toString());
    }

    @ShellMethod
    public void addBook(String title, String authorName, String genreName) {
        bookService.addBook(title, authorName, genreName);
    }

    @ShellMethod
    public void deleteBook(String title) {
        bookService.deleteById(title);
    }

    @ShellMethod
    public void findBook(String title) {
       System.out.println(bookService.toStringWithComments(bookService.findBookByTitle(title))); ;
    }
}
