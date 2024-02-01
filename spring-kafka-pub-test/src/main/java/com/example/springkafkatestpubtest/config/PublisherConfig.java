package com.example.springkafkatestpubtest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;


import com.example.springkafkatestpubtest.publisher.EventPublisher;
import com.example.springkafkatestpubtest.publisher.impl.KafkaEventPublisher;

@Configuration
@RequiredArgsConstructor
public class PublisherConfig {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Bean
    public EventPublisher eventPublisher() {
        return new KafkaEventPublisher(kafkaTemplate);
    }
}
