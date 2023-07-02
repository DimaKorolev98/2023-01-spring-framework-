package ru.otus.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.otus.homework.domain.Genre;


@RepositoryRestResource(path = "GENRES")
public interface GenreDao extends JpaRepository<Genre, Long> {
}
