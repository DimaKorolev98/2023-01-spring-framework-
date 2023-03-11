package ru.otus.homework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.otus.homework.config.AppConfig;
import ru.otus.homework.dao.ExamProducer;
import ru.otus.homework.domain.Question;
import ru.otus.homework.service.ExamSystemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component("examSystemService")
public class ExamSystemServiceImpl implements ExamSystemService {
    private final ExamProducer reader;
    private final MessageSource messageSource;
    private static final int GEN_SIZE = 100;
    private final AppConfig appConfig;


    @Autowired
    public ExamSystemServiceImpl(final ExamProducer reader, MessageSource messageSource,
                                 AppConfig appConfig
    ) {
        this.reader = reader;
        this.messageSource = messageSource;
        this.appConfig = appConfig;
    }

    @Override
    public List<Question> getQuestionsList(final int i) {
        var questions = reader.getQuestion();

        var retList = new ArrayList<Question>();
        var rndNums = new Random().ints(i * GEN_SIZE, 0, questions.size()).distinct().limit(i);

        rndNums.forEach(
                r -> {
                    retList.add(questions.get(r));
                }
        );

        return retList;
    }

    @Override
    public String formatExamCase(Question question) {
        final String[] answers = {""};
        final int[] i = {1};
        question.getAnswers().forEach(a -> answers[0] = String.format("%s\r\n%d. %s", answers[0], i[0]++, a));
        return question.getQuestion() + answers[0];
    }
}
