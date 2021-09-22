package com.soccergao.user.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soccergao.user.exceptions.JsonConversionException;
import org.springframework.stereotype.Component;

@Component
public class JsonConverter {

    private final ObjectMapper objectMapper;

    public JsonConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String writeValueAsString(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new JsonConversionException(e);
        }
    }
}
