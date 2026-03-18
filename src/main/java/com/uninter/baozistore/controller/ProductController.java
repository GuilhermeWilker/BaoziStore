package com.uninter.baozistore.controller;

import com.uninter.baozistore.entity.Product;
import com.uninter.baozistore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;


    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll()
    {
        return ResponseEntity.ok().body(service.list());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@RequestBody Product obj ,@PathVariable Long id) {
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }
}
