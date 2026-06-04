package com.springboot.kafka.controller;


import com.springboot.kafka.model.OrderEvent;
import com.springboot.kafka.service.KafkaProducerService;
import com.springboot.kafka.service.OrderEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@SuppressWarnings("NullableProblems")
@Slf4j
public class MessageController {

    private final KafkaProducerService producerService;
    private final OrderEventService orderEventService;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody OrderEvent event) {

        log.info("publish OrderEvent: {}", event);

        producerService.sendMessage(event);

        return ResponseEntity.ok("Message published successfully");
    }

    @PostMapping("/publish/bulk")
    public ResponseEntity<String> publishBulk(
            @RequestBody List<OrderEvent> events) {

        log.info("publish bulk of Orders Events : {}", events);

        events.forEach(producerService::sendMessage);

        return ResponseEntity.ok(
                events.size() + " messages published successfully");
    }

    @GetMapping("/events")
    public ResponseEntity<List<OrderEvent>> getAllProducts() {

        log.info("Getting all Orders Events from orders link");

        List<OrderEvent> events = orderEventService.getAllOrderEvent();

        return ResponseEntity.ok(events);
    }
}