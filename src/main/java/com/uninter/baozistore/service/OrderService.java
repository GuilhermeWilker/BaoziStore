package com.uninter.baozistore.service;

import com.uninter.baozistore.dto.request.OrderRequestDTO;
import com.uninter.baozistore.dto.response.OrderResponseDTO;
import com.uninter.baozistore.entity.Customer;
import com.uninter.baozistore.entity.Order;
import com.uninter.baozistore.entity.Product;
import com.uninter.baozistore.repository.CustomerRepository;
import com.uninter.baozistore.repository.OrderRepository;
import com.uninter.baozistore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public OrderResponseDTO create(OrderRequestDTO dto)
    {
        Customer customer = customerRepository.findById(dto.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        Product product = productRepository.findById(dto.getProduct_id())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Order order = new Order();

        order.setCustomer(customer);
        order.setProduct(product);
        order.setQuantity(dto.getQuantity());

        Order saved = repository.save(order);


        return new OrderResponseDTO(
                saved.getId(),
                saved.getCustomer(),
                saved.getProduct(),
                saved.getQuantity()
        );
    }

    public Order getById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

    public List<Order> list() {
        return repository.findAll();
    }
}
