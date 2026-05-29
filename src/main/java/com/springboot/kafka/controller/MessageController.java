package com.springboot.kafka.controller;


import com.springboot.kafka.model.OrderEvent;
import com.springboot.kafka.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@SuppressWarnings("NullableProblems")
public class MessageController {

    private final KafkaProducerService producerService;

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody OrderEvent event) {

        producerService.sendMessage(event);

        return ResponseEntity.ok("Message published successfully");
    }
}