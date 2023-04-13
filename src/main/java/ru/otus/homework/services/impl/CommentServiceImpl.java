package ru.otus.homework.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.repositories.BookRepository;
import ru.otus.homework.repositories.CommentRepository;
import ru.otus.homework.services.BookService;
import ru.otus.homework.services.CommentService;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final BookService bookService;
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    private final  MongoTemplate mongoTemplate;


    @Override
    public void addComment(String text, String title) {
        Book book = bookService.findBookByTitle(title);
        Comment comment = new Comment(text);
        commentRepository.save(comment);
        List<Comment> comments;

        if(book.getComments() == null){
            comments = new ArrayList<>();
        } else {
            comments = book.getComments();
        }
        comments.add(comment);
        book.setComments(comments);
        bookRepository.save(book);
    }


    @Override
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void deleteAllBookComments(String id) {
        var query = new Query();
        query.addCriteria(new Criteria("_id").is(id));
        Update update = new Update().pull("comments",query);
        mongoTemplate.updateMulti(new Query(), update, "comments");

    }

    @Override
    public Comment findById(String id) {
        return commentRepository.findById(id).get();
    }
}
