package com.cloud.product.service.impl;

import com.cloud.product.api.ProductApi;
import com.cloud.product.bean.Product;
import com.cloud.product.service.ProductService;
// import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
// @DubboService(interfaceClass = ProductApi.class)
public class ProductServiceImpl implements ProductService, ProductApi {
    @Override
    public Product getProduct(Long productId) {
        return Product.builder().id(productId).productName("product-" + productId)
                .price(new BigDecimal("100")).quantity(1).build();
    }

    @Override
    public Product getProductDubbo(Long productId) {
        return Product.builder().id(productId).productName("dubbo-product-" + productId)
                .price(new BigDecimal("100")).quantity(1).build();
    }
}
