package ru.otus.homework.services.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework.repositories.AuthorRepository;
import ru.otus.homework.services.AuthorService;
import ru.otus.homework.domain.Author;

import javax.transaction.Transactional;
import java.util.List;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    @Override
    public Author findByName(String authorName) {

        return authorRepository.findByName(authorName);
    }

    @Transactional
    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Transactional
    @Override
    public List<Author> findAll() {
        return newArrayList(authorRepository.findAll());
    }
}
