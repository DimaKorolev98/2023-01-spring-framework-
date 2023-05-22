package ru.otus.homework.rest;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Genre;
import ru.otus.homework.repositories.AuthorRepository;
import ru.otus.homework.repositories.BookRepository;
import ru.otus.homework.repositories.GenreRepository;
import ru.otus.homework.rest.dto.BookDto;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookRepository repository;
    private final AuthorRepository authorDao;
    private final GenreRepository genreDao;

    @GetMapping("/api/books")
    public Flux<BookDto> listBooks() {
        return repository.findAll()
                .map(BookDto::toDto);
    }

    @PostMapping("/api/books")
    public Mono<BookDto> saveOrUpdate(@RequestBody BookDto bookDto) {
        return Mono.just(BookDto.toObject(bookDto))
                .flatMap(book -> genreDao.findById(book.getGenre().getId())
                        .switchIfEmpty(genreDao.save(new Genre(book.getGenre().getName())))
                        .flatMap(genre -> {
                            book.setGenre(genre);
                            return authorDao.findByName(book.getAuthor().getId())
                                    .switchIfEmpty(authorDao.save(new Author(book.getAuthor().getName())))
                                    .map(author -> {
                                        book.setAuthor(author);
                                        return book;
                                    });
                        })
                )
                .flatMap(repository::save)
                .map(BookDto::toDto)
                .onErrorMap(ex -> new RuntimeException("Failed to save or update Book", ex));
    }

    @GetMapping("/api/book")
    public Mono<BookDto> getBook(@RequestParam("id") String id){
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Не нашёл такую книгу")))
                .map(BookDto::toDto);
    }

    @PostMapping("/api/book")
    public void deleteBook(@RequestParam("id") String id){
        repository.deleteById(id).subscribe();
    }
}
