package com.cloud.product.controller;

import com.cloud.product.bean.Product;
import com.cloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getProduct/{productId}")
    public Product getProduct(@PathVariable("productId") Long productId) {
        System.out.println("hello");
        Product product = productService.getProduct(productId);
        return product;
    }
}
