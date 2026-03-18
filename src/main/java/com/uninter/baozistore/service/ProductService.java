package com.uninter.baozistore.service;

import com.uninter.baozistore.entity.Product;
import com.uninter.baozistore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product create(Product obj)
    {
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Product getById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public List<Product> list() {
        return repository.findAll();
    }

    public Product update(Product obj)
    {
        Optional<Product> newObj = repository.findById(obj.getId());
        updateCostumer(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateCostumer(Optional<Product> newObj, Product obj) {
        newObj.get().setName(obj.getName());
    }
}
