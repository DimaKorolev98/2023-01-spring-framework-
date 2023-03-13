package ru.otus.homework.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.dao.BookDao;
import ru.otus.homework.dao.CommentDao;
import ru.otus.homework.domain.Comment;

import javax.transaction.Transactional;


@ShellComponent
public class CommentCRUD {

    private final CommentDao commentDao;

    public CommentCRUD(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @ShellMethod
    public void findAllComments(){
        System.out.println(commentDao.getAll().toString());
    }

    @ShellMethod
    @Transactional
    public void addComment(String title , String text){
        commentDao.addComment(title,text);
    }
}
