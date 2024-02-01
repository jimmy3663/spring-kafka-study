package com.example.springkafkasubtest.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Slf4j
@UtilityClass
public class ObjectMapperUtils {
    public static final ObjectMapper defaultObjectMapper = createDefaultObjectMapper();

    public static ObjectMapper createDefaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModules(new JavaTimeModule());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    public static <T> String toJson(final T data) {
        try {
            return defaultObjectMapper.writeValueAsString(data);
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * Json 을 Object 로 반환
     *
     * @param json Json 문자열
     * @param reference 변환할 타입
     * @return 변환된 Object
     * @param <T> Object
     */
    public static <T> T fromJson(final String json, final TypeReference<T> reference) {
        try {
            return defaultObjectMapper.readValue(json, reference);
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
