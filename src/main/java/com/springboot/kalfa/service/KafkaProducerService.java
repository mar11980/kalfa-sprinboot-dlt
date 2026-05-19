package com.springboot.kalfa.service;


import com.springboot.kalfa.configuration.KafkaTopicConfig;
import com.springboot.kalfa.model.OrderEvent;
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

        kafkaTemplate.send(KafkaTopicConfig.ORDER_TOPIC, event.getOrderId(), event);
    }
}