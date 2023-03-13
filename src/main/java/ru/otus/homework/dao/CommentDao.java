package ru.otus.homework.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import java.util.List;

@Service
public class CommentDao implements LibDao<Comment> {

    private final BookDao bookDao;
    @PersistenceContext
    private final EntityManager entityManager;


    public CommentDao(BookDao bookDao, EntityManager entityManager) {
        this.bookDao = bookDao;
        this.entityManager = entityManager;
    }

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() == null) {
            entityManager.persist(comment);
        } else {
            entityManager.merge(comment);
        }
        return comment;
    }

    @Override
    public void delete(Comment comment) {
        entityManager.remove(comment);
    }

    @Override
    public List<Comment> getAll() {
        return entityManager.createQuery("select c from Comment c", Comment.class).getResultList();
    }

    @Override
    public Comment findByName(String name) {
        return null;
    }

    public void addComment(String title , String text){
        Comment comment = new Comment();
        comment.setText(text);
        var book = bookDao.findByName(title);
        if(book == null){
            System.out.println("Нет такой книги: " + title);
        } else {
            comment.setBook(book);
            save(comment);
        }
    }
}
