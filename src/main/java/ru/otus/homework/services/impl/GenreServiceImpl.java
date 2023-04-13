package ru.otus.homework.services.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.repositories.GenreRepository;
import ru.otus.homework.services.GenreService;

import java.util.ArrayList;
import java.util.List;

@Service("genreService")
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        return new ArrayList<Genre>(genreRepository.findAll());
    }

    @Override
    public void deleteById(String name) {
    genreRepository.deleteById(genreRepository.findByName(name).getId());
    }

    @Override
    public Genre addGenre(String name) {
        return genreRepository.save(new Genre(name));
    }

    @Override
    public Genre findByName(String name) {
        return genreRepository.findByName(name);
    }
}
