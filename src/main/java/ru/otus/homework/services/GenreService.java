package ru.otus.homework.services;

import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAll();
    void deleteById(String name);
    Genre addGenre (String name);
    Genre findByName(String name);
}
