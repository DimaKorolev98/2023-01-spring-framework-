package ru.otus.homework.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.homework.domain.Comment;


public interface CommentRepository extends MongoRepository<Comment, String> {

}
