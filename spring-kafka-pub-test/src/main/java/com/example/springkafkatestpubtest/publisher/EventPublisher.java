package com.example.springkafkatestpubtest.publisher;

import com.example.springkafkatestpubtest.event.TestEvent;

public interface EventPublisher {
    void publish(TestEvent event);
}
