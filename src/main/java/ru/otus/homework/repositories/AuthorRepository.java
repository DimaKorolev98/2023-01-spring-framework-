package ru.otus.homework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author deleteById(long id);
    Author findByName(String authorName);
}
