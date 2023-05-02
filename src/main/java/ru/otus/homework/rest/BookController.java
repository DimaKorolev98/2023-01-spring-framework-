package ru.otus.homework.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.homework.repositories.BookRepository;
import ru.otus.homework.rest.dto.BookDto;
import ru.otus.homework.services.BookService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookRepository repository;
    private final BookService service;

    @GetMapping("/api/books")
    public List<BookDto> getAllBooks() {
        return repository.findAll().stream().map(BookDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/api/books")
    public BookDto saveBook(@RequestBody BookDto bookDto) {
        var savedBook = service.saveBook(bookDto);
        return BookDto.toDto(savedBook);
    }

    @GetMapping("/api/book")
    public BookDto getBook(@RequestParam("id") long id){
        return BookDto.toDto(repository.findById(id).orElseThrow(NullPointerException::new));
    }

    @PostMapping("/api/book")
    public void deleteBook(@RequestParam("id") long id){
       repository.deleteById(id);
    }
}
