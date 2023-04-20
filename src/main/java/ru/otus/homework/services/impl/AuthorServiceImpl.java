package ru.otus.homework.services.impl;

import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;
import ru.otus.homework.repositories.AuthorRepository;
import ru.otus.homework.services.AuthorService;
import ru.otus.homework.domain.Author;

import javax.transaction.Transactional;
import java.util.List;



@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findByName(String authorName) {

        return authorRepository.findByName(authorName);
    }


    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }


    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }


    @Override
    public List<Author> findAll() {
        return Lists.newArrayList(authorRepository.findAll());
    }
}
