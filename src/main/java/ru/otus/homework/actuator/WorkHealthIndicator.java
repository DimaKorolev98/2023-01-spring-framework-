package ru.otus.homework.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class WorkHealthIndicator implements HealthIndicator {
    Random random = new Random();
    @Override
    public Health health() {
        if (random.nextBoolean()) {
            return Health.status(Status.UP)
                    .withDetail("message", "Приложение доступно")
                    .build();
        } else {
            return Health.status(Status.DOWN)
                    .withDetail("message", "Приложение недоступно")
                    .build();
        }
    }
}
