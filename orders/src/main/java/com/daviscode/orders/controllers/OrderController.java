package com.daviscode.orders.controllers;

import com.daviscode.orders.model.Order;
import com.daviscode.orders.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> findAll(){
        return this.orderService.findAll() ;
    }

    @GetMapping("/{id}")
    public Optional<Order> findByID(@PathVariable String id){
        return this.orderService.findByID(id);
    }

    @PostMapping
    public Order save(@RequestBody Order order){
        return this.orderService.save(order);
    }

}
