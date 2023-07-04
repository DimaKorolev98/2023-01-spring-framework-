package ru.otus.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.otus.homework.domain.Author;

@RepositoryRestResource(path = "AUTHORS")
public interface AuthorDao extends JpaRepository<Author, Long> {
}
