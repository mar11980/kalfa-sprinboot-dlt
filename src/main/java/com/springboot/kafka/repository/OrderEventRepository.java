package com.springboot.kafka.repository;

import com.springboot.kafka.model.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("NullableProblems")
@Repository
public interface OrderEventRepository extends JpaRepository<OrderEvent, Integer>{
}
