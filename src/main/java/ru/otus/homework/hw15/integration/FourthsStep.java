package ru.otus.homework.hw15.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.homework.hw15.domain.Butterfly;
import ru.otus.homework.hw15.domain.Ground;


import java.util.Collection;

@MessagingGateway
public interface FourthsStep {

    @Gateway(requestChannel = "butterflyChannel", replyChannel = "groundChannel")
    Ground process(Butterfly butterfly);
}
