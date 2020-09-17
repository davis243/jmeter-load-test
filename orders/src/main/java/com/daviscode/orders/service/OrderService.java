package com.daviscode.orders.service;

import com.daviscode.orders.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<Order> findByID(String id);
    Order save(Order order);
    List<Order> findAll();

}
