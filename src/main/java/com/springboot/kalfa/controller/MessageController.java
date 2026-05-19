package com.springboot.kalfa.controller;


import com.springboot.kalfa.model.OrderEvent;
import com.springboot.kalfa.service.KafkaProducerService;
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