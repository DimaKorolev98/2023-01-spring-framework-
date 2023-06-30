package ru.otus.homework.hw15.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import ru.otus.homework.hw15.service.TransformationService;




@Configuration
public class ChannelConfig {


    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate(100).maxMessagesPerPoll(2).get();
    }

    @Bean
    public QueueChannel eggsChannel() {
        return MessageChannels.queue( 50 ).get();
    }

    @Bean
    public PublishSubscribeChannel caterpillarChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean
    public PublishSubscribeChannel cocoonChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean
    public PublishSubscribeChannel butterflyChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean
    public PublishSubscribeChannel groundChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean
    public IntegrationFlow eggsFlow(TransformationService transformationService) {
        return IntegrationFlows.from( "eggsChannel" )
                .handle( transformationService, "transformToCaterpillar" )
                .channel( "caterpillarChannel" )
                .get();
    }

    @Bean
    public IntegrationFlow caterpillarFlow(TransformationService transformationService) {
        return IntegrationFlows.from( "caterpillarChannel" )
                .split()
                .handle( transformationService, "transformToCocoon" )
                .aggregate()
                .channel( "cocoonChannel" )
                .get();
    }

    @Bean
    public IntegrationFlow cocoonFlow(TransformationService transformationService) {
        return IntegrationFlows.from( "cocoonChannel" )
                .split()
                .handle( transformationService, "transformToButterfly" )
                .aggregate()
                .channel( "butterflyChannel" )
                .get();
    }

    @Bean
    public IntegrationFlow groundFlow(TransformationService transformationService
    ) {
        return IntegrationFlows.from( "butterflyChannel" )
                .split()
                .handle( transformationService, "transformToGround" )
                .aggregate()
                .channel( "groundChannel" )
                .get();
    }
}
