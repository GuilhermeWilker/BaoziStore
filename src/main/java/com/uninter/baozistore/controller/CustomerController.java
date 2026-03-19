package com.uninter.baozistore.controller;

import com.uninter.baozistore.entity.Customer;
import com.uninter.baozistore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;


    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll()
    {
        return ResponseEntity.ok().body(service.list());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> update(@RequestBody Customer obj ,@PathVariable Long id) {
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }
}
