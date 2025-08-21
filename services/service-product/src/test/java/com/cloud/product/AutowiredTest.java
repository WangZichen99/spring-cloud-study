package com.cloud.product;

import com.cloud.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AutowiredTest {
    // @Autowired
    private final ProductService productService;

    @Autowired
    private ProductApplication productApplication;

    @Autowired
    public AutowiredTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void test() {
        System.out.println(productApplication);
        productService.getProduct(1L);
    }
}
