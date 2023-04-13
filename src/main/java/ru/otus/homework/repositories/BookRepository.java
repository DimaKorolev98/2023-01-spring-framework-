package ru.otus.homework.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.homework.domain.Book;

import java.util.List;


public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findAll();
    Book findByTitle(String title);


}
