package ru.otus.homework.services;

import ru.otus.homework.domain.Book;

public interface BookService extends GenericDomainCrud<Long, Book> {
    Book findByTitle(String title);
    void addBook(String title, String authorName, String genreName);
}
