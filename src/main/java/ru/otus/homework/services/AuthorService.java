package ru.otus.homework.services;

import ru.otus.homework.domain.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findByName(String name);
    void deleteById(String name);
    Author addAuthor(String name);

}
