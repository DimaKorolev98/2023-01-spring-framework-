package ru.otus.homework.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.repositories.GenreRepository;
import ru.otus.homework.rest.dto.GenreDto;
import ru.otus.homework.rest.dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
public class GenreController {

    private final GenreRepository genreRepository;

    @GetMapping("/api/genres")
    public List<GenreDto> getAllGenres() {
        return genreRepository.findAll().stream().map(GenreDto::toDto)
                .collect(Collectors.toList());
    }
}
