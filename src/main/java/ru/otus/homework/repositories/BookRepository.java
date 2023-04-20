package ru.otus.homework.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByTitle(String title);
    List<Book> findAll();
}
