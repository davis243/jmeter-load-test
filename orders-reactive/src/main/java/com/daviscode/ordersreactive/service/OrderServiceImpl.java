package com.daviscode.ordersreactive.service;

import com.daviscode.orders.model.Order;

import com.daviscode.ordersreactive.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Mono<Order> findByID(String id) {
        return this.orderRepository.findById(id);
    }

    @Override
    public Mono<Order> save(Order order) {
            order.setOrderDate(LocalDateTime.now());
        return this.orderRepository.save(order);
    }

    @Override
    public Flux<Order> findAll() {
        return  this.orderRepository.findAll();
    }
}
