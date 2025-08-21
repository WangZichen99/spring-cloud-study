package com.cloud.product;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoveryTest {
    @Autowired
    private DiscoveryClient discoveryClient; // Spring Cloud提供的服务发现
    @Autowired
    private NacosServiceDiscovery nacosServiceDiscovery; // Spring Cloud Alibaba Nacos提供的注册发现

    @Test
    public void discoveryClientTest() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getHost() + ":" + instance.getPort());
            }
        }
    }

    @Test
    public void nacosDiscoveryClientTest() throws NacosException {
        for (String service : nacosServiceDiscovery.getServices()) {
            System.out.println(service);
            for (ServiceInstance instance : nacosServiceDiscovery.getInstances(service)) {
                System.out.println(instance.getHost() + ":" + instance.getPort());
            }

        }
    }
}
