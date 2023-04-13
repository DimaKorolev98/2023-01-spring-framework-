package ru.otus.homework.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.repositories.BookRepository;
import ru.otus.homework.repositories.GenreRepository;


@ShellComponent
public class GenreCRUD {
    private final GenreRepository genreRepository;

    public GenreCRUD(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @ShellMethod
    public void findAllGenres() {
        System.out.println(genreRepository.findAll().toString());
    }

    @ShellMethod
    public void addGenre(String name) {
        genreRepository.save(new Genre(name));
    }

    @ShellMethod
    public void deleteGenre(String name) {
        genreRepository.delete(genreRepository.findByName(name));
    }
    @ShellMethod
    public void findGenre(String name) {
        System.out.println(genreRepository.findByName(name));
    }
}
