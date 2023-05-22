package ru.otus.homework.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.otus.homework.domain.Author;
import ru.otus.homework.repositories.AuthorRepository;
import ru.otus.homework.rest.dto.AuthorDto;
import ru.otus.homework.rest.dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping("/api/authors")
    public Flux<AuthorDto> getAllAuthors() {
        return authorRepository.findAll()
                .map(AuthorDto::toDto);
   }
}
