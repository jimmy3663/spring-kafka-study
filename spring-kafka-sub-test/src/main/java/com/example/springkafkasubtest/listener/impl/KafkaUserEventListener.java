package com.example.springkafkasubtest.listener.impl;

import static com.example.springkafkasubtest.utils.ObjectMapperUtils.*;

import java.util.Objects;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import com.example.springkafkasubtest.event.UserEvent;
import com.example.springkafkasubtest.listener.UserEventListener;
import com.example.springkafkasubtest.policyhandler.UserPolicyHandler;
import com.fasterxml.jackson.core.type.TypeReference;

@Slf4j
@RequiredArgsConstructor
public class KafkaUserEventListener implements UserEventListener {
    private final UserPolicyHandler userPolicyHandler;

    @Override
    @KafkaListener(topics = "test2", groupId = "one")
    public void handleUserEvent(@Headers MessageHeaders headers, @Payload String event) {
        UserEvent userEvent = fromJson(event, new TypeReference<>() {});

        log.info("headers : {} , event message : {}", headers, event);

        Integer partition = (Integer) headers.get("kafka_receivedPartitionId");
        if(Objects.isNull(partition)) {
            log.error("Partition is null");
            return;
        }

        if (partition % 2 == 0) {
            userPolicyHandler.handleUserPolicy(userEvent);
        } else {
            userPolicyHandler.handleUserPolicyWithException(userEvent);
        }
    }
}
