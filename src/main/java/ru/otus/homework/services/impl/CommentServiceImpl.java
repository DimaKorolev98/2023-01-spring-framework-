package ru.otus.homework.services.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.repositories.CommentRepository;
import ru.otus.homework.services.CommentService;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional
    @Override
    public Comment save(Comment domain) {
        return null;
    }

    @Transactional
    @Override
    public void delete(Comment domain) {

    }

    @Transactional
    @Override
    public List<Comment> findAll() {
        return null;
    }
}
