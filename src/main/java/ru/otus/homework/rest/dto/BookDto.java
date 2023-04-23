package ru.otus.homework.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;


@Data
@AllArgsConstructor
public class BookDto {

    private long id;
    private String title;
    private String author;
    private String genre;

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor().getName(), book.getGenre().getName());
    }


}
