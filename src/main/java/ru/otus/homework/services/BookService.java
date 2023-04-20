package ru.otus.homework.services;

import ru.otus.homework.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService extends GenericDomainCrud<Long, Book> {
    Book findByTitle(String title);
    List<Book> findAll();
    void addBook(Book book, String title, String authorName, String genreName);
}
