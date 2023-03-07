package ru.otus.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.otus.homework.config.AppConfig;
import ru.otus.homework.service.ExaminationService;
import ru.otus.homework.service.StudentService;

import java.util.Locale;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class Application {
    public static void main(String[] args){
        Locale.setDefault(Locale.ENGLISH);
        var context = SpringApplication.run(Application.class);
        var examinationService = context.getBean("examinationService", ExaminationService.class);

        var studentService = context.getBean("studentService", StudentService.class);
        examinationService.takeExam();
    }
}
