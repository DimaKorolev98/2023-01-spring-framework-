package ru.otus.homework.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.homework.domain.Book;

import java.util.List;


public interface BookRepository extends ReactiveMongoRepository<Book, String> {


}
