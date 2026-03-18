package com.uninter.baozistore.repository;

import com.uninter.baozistore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
