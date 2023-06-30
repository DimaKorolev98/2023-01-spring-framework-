package ru.otus.homework.hw15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;
import ru.otus.homework.hw15.service.TransformationService;

@SpringBootApplication
@IntegrationComponentScan
public class IntegrationApplication015 {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(IntegrationApplication015.class, args);
        TransformationService service = ctx.getBean(TransformationService.class);
        service.transform();

    }
}