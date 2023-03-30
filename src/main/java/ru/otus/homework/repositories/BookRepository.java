package ru.otus.homework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Book;


public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByTitle(String title);
}
