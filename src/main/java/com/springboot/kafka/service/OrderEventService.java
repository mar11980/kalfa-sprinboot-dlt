package com.springboot.kafka.service;

import com.springboot.kafka.model.OrderEvent;
import com.springboot.kafka.repository.OrderEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderEventService {

    private final OrderEventRepository orderEventRepository;

    public OrderEvent save(OrderEvent orderEvent){
        return orderEventRepository.save(orderEvent);
    }
}
