package ru.otus.homework.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;

import java.util.List;


@Data
@AllArgsConstructor
public class BookDto {

    private String id;
    private String title;
    private AuthorDto author;
    private GenreDto genre;


    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getTitle(), AuthorDto.toDto(book.getAuthor()), GenreDto.toDto(book.getGenre()));
    }

    public static Book toObject(BookDto bookDto){
        return new Book(bookDto.getId(), bookDto.getTitle(), AuthorDto.toObject(bookDto.getAuthor()) , GenreDto.toObject(bookDto.getGenre()));
    }
}
