package ru.otus.homework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Genre;


public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre findByName(String genreName);
}
