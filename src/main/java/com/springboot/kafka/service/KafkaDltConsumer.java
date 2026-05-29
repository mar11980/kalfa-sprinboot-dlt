package com.springboot.kafka.service;

import com.springboot.kafka.model.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

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