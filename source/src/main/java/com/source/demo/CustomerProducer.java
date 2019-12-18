package com.source.demo;

import com.demo.CloudMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(Source.class)
@RequiredArgsConstructor
public class CustomerProducer {

    private final CustomerRepository repository;

    @Bean
    @InboundChannelAdapter(
            value = Source.OUTPUT,
            poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1")
    )
    public MessageSource<CloudMessage> timeMessageSource() {
        return () -> MessageBuilder.withPayload(
                repository.findAllByStateOrderById("DRAFT").stream().findFirst().map(CloudMessage::new).orElseGet(CloudMessage::new)
        ).build();
    }
}
