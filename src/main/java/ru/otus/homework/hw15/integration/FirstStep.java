package ru.otus.homework.hw15.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.homework.hw15.domain.Egg;

@MessagingGateway
public interface FirstStep {

    @Gateway(requestChannel = "eggsChannel", replyChannel = "caterpillarChannel")
    void process(Egg egg);
}
