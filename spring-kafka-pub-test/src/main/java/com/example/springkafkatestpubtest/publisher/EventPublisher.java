package com.example.springkafkatestpubtest.publisher;

import com.example.springkafkatestpubtest.event.AbstractEvent;
import com.example.springkafkatestpubtest.event.TestEvent;

public interface EventPublisher {
    void publish(AbstractEvent event);
}
