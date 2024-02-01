package com.example.springkafkatestpubtest.event;

import lombok.*;

@Getter
@Builder(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestEvent {
    private String message;

    public static TestEvent of(String message) {
        return TestEvent.builder()
                .message(message)
                .build();
    }
}
