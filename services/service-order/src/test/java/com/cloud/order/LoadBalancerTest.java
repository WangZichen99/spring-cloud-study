package com.cloud.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@SpringBootTest
public class LoadBalancerTest {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void test() {
        for (int i = 0; i < 5; i++) {
            ServiceInstance instance = loadBalancerClient.choose("service-product");
            System.out.println(instance.getHost() + ":" + instance.getPort());
        }
    }
}
