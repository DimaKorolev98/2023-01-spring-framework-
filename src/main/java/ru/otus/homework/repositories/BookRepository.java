package ru.otus.homework.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.otus.homework.domain.Book;


public interface BookRepository extends ReactiveMongoRepository<Book, String> {
}
