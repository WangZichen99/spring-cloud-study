package com.cloud.order.feign.fallback;

import com.cloud.order.feign.ProductFeignClient;
import com.cloud.product.bean.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product getProduct(Long productId) {
        System.out.println("兜底数据");
        return Product.builder().id(productId).productName("未知商品").price(BigDecimal.ZERO).quantity(0).build();
    }
}
