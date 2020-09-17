package com.daviscode.orders.service;

import com.daviscode.orders.model.Order;
import com.daviscode.orders.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findByID(String id) {
        return this.orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
            order.setOrderDate(LocalDateTime.now());
        return this.orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return  this.orderRepository.findAll();
    }
}
