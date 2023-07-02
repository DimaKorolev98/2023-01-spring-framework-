package ru.otus.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.otus.homework.domain.Comment;

@RepositoryRestResource(path = "COMMENTS")
public interface CommentDao extends JpaRepository<Comment, Long> {
}
