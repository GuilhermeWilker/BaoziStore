package com.uninter.baozistore.dto.response;

import com.uninter.baozistore.entity.Customer;
import com.uninter.baozistore.entity.Product;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private Customer customer_id;
    private Product product_id;
    private Integer quantity;
}