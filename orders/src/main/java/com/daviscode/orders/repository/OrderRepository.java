package com.daviscode.orders.repository;

import com.daviscode.orders.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
