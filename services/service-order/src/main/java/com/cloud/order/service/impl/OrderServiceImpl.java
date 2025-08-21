package com.cloud.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.order.bean.Order;
import com.cloud.order.feign.ProductFeignClient;
import com.cloud.order.service.OrderService;
import com.cloud.product.api.ProductApi;
import com.cloud.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
// import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Collections;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private ProductFeignClient productFeignClient;
    // @DubboReference
    // private ProductApi productService;

    @SentinelResource(value = "createOrder", blockHandler = "createOrderHandler", fallback = "createOrderFallback")
    @Override
    public Order createOrder(Long userId, Long productId) {
        Product product = getProduct(productId);
        return Order.builder()
                .id(1L).userId(userId).nickName("张三").address("北京")
                .totalAmount(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .products(Collections.singletonList(product)).build();
    }

    public static Order createOrderHandler(Long userId, Long productId, BlockException e) {
        return Order.builder()
                .id(0L).userId(userId).nickName("未知用户").address("")
                .products(Collections.emptyList()).totalAmount(BigDecimal.ZERO).build();
    }

    public Order createOrderFallback(Long userId, Long productId, Throwable t) {
        return Order.builder()
                .id(0L).userId(userId).nickName("未知用户").address("")
                .products(Collections.emptyList()).totalAmount(BigDecimal.ZERO).build();
    }

    private Product getProduct(Long productId) {
        // 使用DiscoveryClient服务发现获取实例
        // List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        // ServiceInstance serviceInstance = instances.get(0);

        // 使用LoadBalancerClient负载均衡轮询获取实例
        // ServiceInstance serviceInstance = loadBalancerClient.choose("service-product");
        // String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/getProduct/" + productId;

        // 使用负载均衡注解自动解析url中的服务名实例地址
        // String url = "http://service-product/product/getProduct/" + productId;
        // log.info("远程请求:" + url);
        // Product product = restTemplate.getForObject(url, Product.class);

        //使用Feign
        Product product = productFeignClient.getProduct(productId);

        //使用Dubbo
        // Product product = productService.getProductDubbo(productId);
        return product;
    }
}
