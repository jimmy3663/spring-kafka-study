package com.example.springkafkasubtest.listener;

import org.springframework.messaging.MessageHeaders;

public interface UserEventListener {
    void handleUserEvent(MessageHeaders headers, String event);
}
