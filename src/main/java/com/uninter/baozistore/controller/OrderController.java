package com.uninter.baozistore.controller;

import com.uninter.baozistore.entity.Order;
import com.uninter.baozistore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderController {


    @Autowired
    private OrderService service;


    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll()
    {
        return ResponseEntity.ok().body(service.list());
    }
}
