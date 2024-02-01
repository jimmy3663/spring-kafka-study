package com.example.springkafkasubtest.listener.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.example.springkafkasubtest.listener.EventListener;
import com.example.springkafkasubtest.listener.impl.KafkaEventListener;

@Configuration
@RequiredArgsConstructor
public class EventListenerConfig {
    @Bean
    public EventListener eventListener() {
        return new KafkaEventListener();
    }
}
