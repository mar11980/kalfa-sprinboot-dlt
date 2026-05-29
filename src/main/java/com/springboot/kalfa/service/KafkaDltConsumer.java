package com.springboot.kalfa.service;

import com.springboot.kalfa.model.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Service
public class KafkaDltConsumer {

    @KafkaListener(
            topics = "order-topic-dlt",
            groupId = "dlt-group"
    )
    public void consumeDlt(OrderEvent event) {


        log.error("🚨 Message RECEIVED in DLT EVENT: {}", event);

        // Save into DB
        // Send alert
        // Notify support team
    }
}