package com.springboot.kalfa.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Slf4j
@Configuration
public class KafkaErrorHandler {

    @Bean
    public DefaultErrorHandler errorHandler() {

        FixedBackOff fixedBackOff = new FixedBackOff(1000L, 2L);

        return new DefaultErrorHandler((record, exception) -> {
            log.error("Message moved to DLT: {}", record.value());
            log.error("Reason: {}", exception.getMessage());
        }, fixedBackOff);
    }
}