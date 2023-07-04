package ru.otus.homework.actuator;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import ru.otus.homework.repositories.BookDao;
import ru.otus.homework.repositories.BookRepository;


@Component
@RequiredArgsConstructor
public class BookAvailabilityHealthIndicator implements HealthIndicator {
    private final ApplicationContext context;

    @Override
    public Health health() {
        BookRepository repository = context.getBean("bookRepository", BookRepository.class);
        if (repository.findAll().size()!=0) {
            return Health.status(Status.UP).withDetail("message", "There are some books in DB").build();
        }
        else {
            return Health.status(Status.DOWN).withDetail("message", "No books in DB").build();
        }
    }
}


