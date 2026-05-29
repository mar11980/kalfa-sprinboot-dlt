package com.springboot.kalfa.service;

import com.springboot.kalfa.model.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.BackOff;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;

import org.springframework.stereotype.Service;


@Slf4j
@Service
public class KafkaConsumerService {

    @RetryableTopic(
            attempts = "3",
            backOff = @BackOff(
                    delay = 2000,
                    multiplier = 2.0
            ),
            dltTopicSuffix = "-dlt",
            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE
    )
    @KafkaListener(
            topics = "order-topic",
            groupId = "order-group"
    )
    public void consume(OrderEvent event) {

        log.info("Received event: {}", event);

        String email = event.getEmail();

        boolean validEmail = email != null
                && email.matches("^[A-Za-z0-9+_.-]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,}$");

        if (!validEmail) {
            throw new RuntimeException("Invalid email format");
        }

        log.info("Order : {} processed successfully", event);
    }

    @DltHandler
    public void dlt(OrderEvent event) {
        log.error("Message arrived in DLT: {}", event);
    }
}