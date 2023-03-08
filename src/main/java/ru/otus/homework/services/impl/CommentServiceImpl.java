package ru.otus.homework.services.impl;


import org.springframework.stereotype.Service;
import ru.otus.homework.dao.CommentRepository;
import ru.otus.homework.dao.CommentService;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Comment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment save(Comment domain) {
        return commentRepository.save(domain);
    }

    @Override
    public void delete(Comment domain) {
        commentRepository.delete(domain);
    }

    @Override
    public List<Comment> findAll() {
        return newArrayList(commentRepository.findAll());
    }
}
