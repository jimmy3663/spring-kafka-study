package com.example.springkafkatestpubtest.publisher.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.example.springkafkatestpubtest.event.AbstractEvent;
import com.example.springkafkatestpubtest.event.TestEvent;
import com.example.springkafkatestpubtest.publisher.EventPublisher;

import static com.example.springkafkatestpubtest.utils.ObjectMapperUtils.toJson;

@RequiredArgsConstructor
public class KafkaEventPublisher implements EventPublisher {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void publish(AbstractEvent event) {
        Message<String> message = MessageBuilder
                .withPayload(toJson(event))
                .setHeader(KafkaHeaders.TOPIC, "test2")
                .build();

        this.kafkaTemplate.send(message);
    }
}
