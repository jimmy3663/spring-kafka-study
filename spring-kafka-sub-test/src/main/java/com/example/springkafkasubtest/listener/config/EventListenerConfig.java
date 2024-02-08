package com.example.springkafkasubtest.listener.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.example.springkafkasubtest.listener.UserEventListener;
import com.example.springkafkasubtest.listener.impl.KafkaUserEventListener;
import com.example.springkafkasubtest.policyhandler.UserPolicyHandler;

@Configuration
@RequiredArgsConstructor
public class EventListenerConfig {
    private final UserPolicyHandler userPolicyHandler;
    @Bean
    public UserEventListener eventListener() {
        return new KafkaUserEventListener(this.userPolicyHandler);
    }
}
