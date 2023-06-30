package ru.otus.homework.hw15.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.homework.hw15.domain.Butterfly;
import ru.otus.homework.hw15.domain.Caterpillar;
import ru.otus.homework.hw15.domain.Cocoon;


import java.util.Collection;

@MessagingGateway
public interface ThirdStep {

    @Gateway(requestChannel = "cocoonChannel", replyChannel = "butterflyChannel")
    Butterfly process(Cocoon cocoon);
}
