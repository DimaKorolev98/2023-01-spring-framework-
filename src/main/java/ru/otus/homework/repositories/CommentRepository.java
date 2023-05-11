package ru.otus.homework.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.homework.domain.Comment;


public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {

}
