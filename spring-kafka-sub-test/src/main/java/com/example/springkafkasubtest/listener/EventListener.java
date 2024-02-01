package com.example.springkafkasubtest.listener;

import org.springframework.messaging.MessageHeaders;


import com.example.springkafkasubtest.event.TestEvent;

public interface EventListener {
    void handleTestEvent(MessageHeaders headers, String event);
}
