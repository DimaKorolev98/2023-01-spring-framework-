package ru.otus.homework.events;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeDeleteEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.repositories.BookRepository;
import ru.otus.homework.repositories.CommentRepository;
import ru.otus.homework.services.BookService;
import ru.otus.homework.services.CommentService;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class MongoCommentCascadeDeleteEventsListener extends AbstractMongoEventListener<Book> {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @Override
    public void onBeforeDelete(BeforeDeleteEvent<Book> event) {
        super.onBeforeDelete(event);
        var source = event.getSource();
        var id = source.get("_id").toString();
        try {
            bookRepository.findById(id).get()
                    .getComments()
                    .forEach(x -> commentRepository
                            .deleteById(x.getId()));
        } catch (NullPointerException e) {
            System.out.println("Нет комментариев для удаления; Книга удалена");
        }
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Book> event) {
        super.onBeforeConvert(event);
        var book = event.getSource();
        try {
            book.setComments(new ArrayList<Comment>(book.getComments()));
        }catch (NullPointerException e){

        }
    }
}
