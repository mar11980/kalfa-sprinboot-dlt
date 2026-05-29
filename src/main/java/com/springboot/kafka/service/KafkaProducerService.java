package com.springboot.kafka.service;

import com.springboot.kafka.configuration.KafkaTopicConfig;
import com.springboot.kafka.model.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@SuppressWarnings("NullableProblems")
public class KafkaProducerService {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendMessage(OrderEvent event) {

        log.info("Sending event: {}", event);

        kafkaTemplate.send(KafkaTopicConfig.ORDER_TOPIC, event.getOrderId().toString(), event);
    }
}