package com.cloud.product.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {
    private Long id;
    private BigDecimal price;
    private String productName;
    private Integer quantity;
}
