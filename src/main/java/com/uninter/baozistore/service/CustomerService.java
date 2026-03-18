package com.uninter.baozistore.service;

import com.uninter.baozistore.entity.Customer;
import com.uninter.baozistore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer create(Customer obj)
    {
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Customer getById(Long id){
        Optional<Customer> obj = repository.findById(id);
        return obj.get();
    }

    public List<Customer> list() {
        return repository.findAll();
    }

    public Customer update(Customer obj)
    {
        Optional<Customer> newObj = repository.findById(obj.getId());
        updateCostumer(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateCostumer(Optional<Customer> newObj, Customer obj) {
        newObj.get().setName(obj.getName());
    }
}
