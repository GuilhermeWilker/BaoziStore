package com.uninter.baozistore.dto.request;

import lombok.Data;

@Data
public class OrderRequestDTO {
    private Long customer_id;
    private Long product_id;
    private Integer quantity;
}