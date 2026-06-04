package com.springboot.kafka.service;

import com.springboot.kafka.model.OrderEvent;
import com.springboot.kafka.repository.OrderEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderEventService {

    private final OrderEventRepository orderEventRepository;

    public void save(OrderEvent orderEvent){
        orderEventRepository.save(orderEvent);
    }

    public List<OrderEvent> getAllOrderEvent(){
       return  orderEventRepository.findAll();
    }


}
