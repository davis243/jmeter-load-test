package com.daviscode.ordersreactive.service;

import com.daviscode.orders.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Mono<Order> findByID(String id);
    Mono<Order> save(Order order);
    Flux<Order> findAll();

}
