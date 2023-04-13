package ru.otus.homework.services;

import ru.otus.homework.domain.Comment;

import java.util.List;

public interface CommentService {
    void addComment(String text, String bookId);
    Comment findById(String id);
    void deleteById(String id);
    void deleteAllBookComments(String id);
}
