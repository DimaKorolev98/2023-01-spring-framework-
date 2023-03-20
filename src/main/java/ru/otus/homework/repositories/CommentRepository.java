package ru.otus.homework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Comment;


public interface CommentRepository extends CrudRepository<Comment, Long> {
    
}
