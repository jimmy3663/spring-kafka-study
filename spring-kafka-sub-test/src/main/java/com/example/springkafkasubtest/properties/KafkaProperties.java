package com.example.springkafkasubtest.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {
    private String bootstrapServers;
    private Consumer consumer;

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Consumer {
        private String groupId;
    }
}

