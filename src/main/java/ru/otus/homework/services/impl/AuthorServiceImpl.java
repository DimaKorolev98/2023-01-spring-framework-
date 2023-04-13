package ru.otus.homework.services.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework.repositories.AuthorRepository;
import ru.otus.homework.services.AuthorService;
import ru.otus.homework.domain.Author;


import java.util.List;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return newArrayList(authorRepository.findAll());
    }

    @Override
    public Author findByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public void deleteById(String name) {
    authorRepository.deleteById(findByName(name).getId());
    }

    @Override
    public Author addAuthor(String name) {
      return authorRepository.save(new Author(name));
    }
}
