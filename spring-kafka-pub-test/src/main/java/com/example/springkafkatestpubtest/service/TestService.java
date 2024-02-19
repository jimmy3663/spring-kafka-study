package com.example.springkafkatestpubtest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import com.example.springkafkatestpubtest.event.TestEvent;
import com.example.springkafkatestpubtest.publisher.EventPublisher;

@Service
@RequiredArgsConstructor
public class TestService {
    private final EventPublisher eventPublisher;

    public void pub(String message) {
        // this.eventPublisher.publish(TestEvent.of(message));
    }
}
