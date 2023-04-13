package ru.otus.homework.services.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.repositories.BookRepository;
import ru.otus.homework.services.AuthorService;
import ru.otus.homework.services.BookService;
import ru.otus.homework.domain.Book;
import ru.otus.homework.services.CommentService;
import ru.otus.homework.services.GenreService;

import java.util.*;
import java.util.stream.Collectors;

@Service("bookService")
@RequiredArgsConstructor

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final GenreService genreService;


    @Override
    public List<Book> findAll() {

        return new ArrayList(bookRepository.findAll());
    }

    @Override
    public void deleteById(String title) {
         bookRepository.deleteById(findBookByTitle(title).getId());
    }

    public void addBook(String title, String authorName, String genreName) {
        Book book = new Book();
        book.setTitle(title);
        var author = authorService.findByName(authorName);
        if (author == null) {
            author = authorService.addAuthor(authorName);
        }
        book.setAuthor(author);

        var genre = genreService.findByName(genreName);
        if (genre == null) {
            genre = genreService.addGenre(genreName);
        }
        book.setGenre(genre);

        bookRepository.save(book);
    }

    @Override
    public Book findBookByTitle(String title) {

        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Comment> getComments(String title) {
        return bookRepository.findByTitle(title).getComments();
    }

    @Override
    public String toStringWithComments(Book book){
        return "Book{" +
                "id='" + book.getId() + '\'' +
                ", Название: '" + book.getTitle() + '\'' +
                ", Автор: " + book.getAuthor().getName() +
                ", Жанр: " + book.getGenre().getName() +
                ", Коментарии: " + (book.getComments() != null ? (book.getComments().
                stream().map(x->x.toString()).collect(Collectors.joining("; "))): "Нет Комментариев" )+
                '}';
    }


}


