package ru.otus.homework.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.services.CommentService;

@ShellComponent
public class CommentCRUD {
    private final CommentService commentService;

    public CommentCRUD(CommentService commentService) {
        this.commentService = commentService;
    }

    @ShellMethod
    public void addComment(String text, String title){
        commentService.addComment(text, title);
    }

    @ShellMethod
    public void deleteAllComments(String id){
        commentService.deleteAllBookComments(id);
    }

}
