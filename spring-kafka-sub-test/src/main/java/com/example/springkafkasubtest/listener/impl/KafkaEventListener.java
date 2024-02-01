package com.example.springkafkasubtest.listener.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;


import com.example.springkafkasubtest.listener.EventListener;

@Slf4j
public class KafkaEventListener implements EventListener {

    @Override
    @KafkaListener(topics = "test2", groupId = "one")
    public void handleTestEvent(@Headers MessageHeaders headers, @Payload String event) {

        log.info("headers : {} , event message : {}", headers, event);
    }
}
