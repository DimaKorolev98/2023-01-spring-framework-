package ru.otus.homework.services;

import ru.otus.homework.domain.Book;
import ru.otus.homework.rest.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService extends GenericDomainCrud<Long, Book> {
    Book findByTitle(String title);
    List<Book> findAll();
    Book saveBook(BookDto bookDto);
}
