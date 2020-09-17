package com.daviscode.ordersreactive.controllers;

import com.daviscode.orders.model.Order;
import com.daviscode.ordersreactive.service.OrderService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> findAll(){
        return this.orderService.findAll() ;
    }

    @GetMapping("/{id}")
    public Mono<Order> findByID(@PathVariable String id){
        return this.orderService.findByID(id);
    }

    @PostMapping
    public Mono<Order> save(@RequestBody Order order){
        return this.orderService.save(order);
    }

}
