package ru.otus.homework.services.impl;

import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;
import ru.otus.homework.repositories.GenreRepository;
import ru.otus.homework.services.GenreService;
import ru.otus.homework.domain.Genre;

import javax.transaction.Transactional;
import java.util.List;

@Service("genreService")
public class GenreServiceImpl implements GenreService {


    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Transactional
    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Transactional
    @Override
    public void delete(Genre genre) {
        genreRepository.delete(genre);
    }

    @Transactional
    @Override
    public List<Genre> findAll() {
        return Lists.newArrayList(genreRepository.findAll());
    }

    @Transactional
    @Override
    public Genre findByName(String genreName) {
        return genreRepository.findByName(genreName);
    }
}
