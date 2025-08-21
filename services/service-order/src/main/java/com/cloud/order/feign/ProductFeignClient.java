package com.cloud.order.feign;

import com.cloud.order.feign.fallback.ProductFeignClientFallback;
import com.cloud.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-product", path = "/product", fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient {
    @GetMapping("/getProduct/{productId}")
    Product getProduct(@PathVariable("productId") Long productId);
}
