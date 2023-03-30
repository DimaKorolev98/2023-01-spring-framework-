package ru.otus.homework.services.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.repositories.CommentRepository;
import ru.otus.homework.services.CommentService;


import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Override
    public Comment save(Comment domain) {
        return null;
    }


    @Override
    public void delete(Comment domain) {

    }

    @Override
    public List<Comment> findAll() {
        return null;
    }
}
