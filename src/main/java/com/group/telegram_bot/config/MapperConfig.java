package com.group.telegram_bot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ObjectMapper objectMapper() {
        var res = new ObjectMapper();
        res.registerModule(new JavaTimeModule());
        return res;
    }
}
