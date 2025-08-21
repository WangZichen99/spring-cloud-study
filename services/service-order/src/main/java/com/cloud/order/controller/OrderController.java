package com.cloud.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.order.bean.Order;
import com.cloud.order.exception.ControllerBlockExceptionHandler;
import com.cloud.order.properties.OrderProperties;
import com.cloud.order.service.OrderService;
import com.cloud.order.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RefreshScope
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderProperties orderProperties;

    @GetMapping("/getConfig")
    public String getConfig() {
        return "timeout = " + orderProperties.getTimeout() +
                "<br>autoConfirm = " + orderProperties.getAutoConfirm() +
                "<br>dbUrl = " + orderProperties.getDbUrl();
    }

    @SentinelResource(value = "createOrderParam", blockHandler = "createOrderHandler", blockHandlerClass = OrderServiceImpl.class)
    @GetMapping("/createOrder")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId) {
        Order order = orderService.createOrder(userId, productId);
        return order;
    }

    @GetMapping("/secKill")
    public Order secKill(@RequestParam("userId") Long userId,
                         @RequestParam("productId") Long productId) {
        Order order = orderService.createOrder(userId, productId);
        return order;
    }

    @GetMapping("/write")
    public String write() {
        return "write success";
    }

    @GetMapping("/read")
    public String read() {
        return "read success";
    }
}
