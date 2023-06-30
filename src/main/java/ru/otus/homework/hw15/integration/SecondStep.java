package ru.otus.homework.hw15.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.homework.hw15.domain.Caterpillar;
import ru.otus.homework.hw15.domain.Cocoon;

import java.util.Collection;

@MessagingGateway
public interface SecondStep {

    @Gateway(requestChannel = "caterpillarChannel", replyChannel = "cocoonChannel")
    Cocoon process(Caterpillar caterpillar);
}
