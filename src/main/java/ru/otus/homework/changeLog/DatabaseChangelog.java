package ru.otus.homework.changeLog;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;

import reactor.core.publisher.Mono;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.repositories.AuthorRepository;
import ru.otus.homework.repositories.BookRepository;
import ru.otus.homework.repositories.CommentRepository;
import ru.otus.homework.repositories.GenreRepository;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Genre;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangelog {
    private final List<Author> authors = new ArrayList<>();
    private final List<Genre> genres = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();


    @ChangeSet(order = "001", id = "dropDb", author = "simba", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "initAuthors", author = "simba")
    public void initAuthors(AuthorRepository authorRepository) {
        authors.add(authorRepository.save(new Author(null, "Энрих Мария Ремарк")).block());
        authors.add(authorRepository.save(new Author(null, "Джон Р. Р. Толкин")).block());
        authors.add(authorRepository.save(new Author(null, "Александр Сергеевич Пушкин")).block());
        authors.add(authorRepository.save(new Author(null, "Роберт Мартин")).block());
    }

    @ChangeSet(order = "003", id = "initGenres", author = "simba")
    public void initGenres(GenreRepository genreRepository) {
        genres.add(genreRepository.save(new Genre(null, "Роман")).block());
        genres.add(genreRepository.save(new Genre(null, "Фантастика")).block());
        genres.add(genreRepository.save(new Genre(null, "Поэма")).block());
        genres.add(genreRepository.save(new Genre(null, "Компьютерные науки")).block());
    }

    @ChangeSet(order = "004", id = "initComments", author = "simba")
    public void initComments(CommentRepository commentRepository) {
        comments.add(commentRepository.save(new Comment(null, "Amazing book!")).block());
        comments.add(commentRepository.save(new Comment(null, "Nice book!")).block());
        comments.add(commentRepository.save(new Comment(null, "Don`t like it")).block());
        comments.add(commentRepository.save(new Comment(null, "It makes me cry")).block());
        comments.add(commentRepository.save(new Comment(null, "Booom!!")).block());
        comments.add(commentRepository.save(new Comment(null, "Great")).block());
        comments.add(commentRepository.save(new Comment(null, "Perfect")).block());
        comments.add(commentRepository.save(new Comment(null, "Cool")).block());
    }

    @ChangeSet(order = "005", id = "initBooks", author = "simba")
    public void initBooks(BookRepository bookRepository) {
        books.add(bookRepository.save(new Book(null, "Три товарища", authors.get(0), genres.get(0),
                List.of(comments.get(0), comments.get(1)))).block());
        books.add(bookRepository.save(new Book(null, "Властелин колец", authors.get(1), genres.get(1),
                List.of(comments.get(2)))).block());
        books.add(bookRepository.save(new Book(null, "Руслан и Людмила",
                authors.get(2), genres.get(2), List.of(comments.get(5), comments.get(4)))).block());
        books.add(bookRepository.save(new Book(null, "Чистый код", authors.get(1),
                genres.get(3), List.of(comments.get(3)))).block());
    }



}