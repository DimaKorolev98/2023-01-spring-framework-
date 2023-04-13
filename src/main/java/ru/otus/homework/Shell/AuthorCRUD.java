package ru.otus.homework.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.domain.Author;
import ru.otus.homework.services.AuthorService;


@ShellComponent
public class AuthorCRUD {
    private final AuthorService authorService;

    public AuthorCRUD(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ShellMethod
    public void findAllAuthors() {
        System.out.println(authorService.findAll().toString());
    }

    @ShellMethod
    public void addAuthor(String name) {
        authorService.addAuthor(name);
    }

    @ShellMethod
    public void deleteAuthor(String name) {
        authorService.deleteById(name);
    }

    @ShellMethod
    public void findAuthor(String name) {
        System.out.println(authorService.findByName(name));
    }
}
