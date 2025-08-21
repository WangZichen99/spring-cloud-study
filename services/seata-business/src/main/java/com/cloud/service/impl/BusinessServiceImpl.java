package com.cloud.service.impl;

import com.cloud.feign.OrderFeignClient;
import com.cloud.feign.StorageFeignClient;
import com.cloud.service.BusinessService;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private StorageFeignClient storageFeignClient;
    @Autowired
    private OrderFeignClient orderFeignClient;

    @Override
    @GlobalTransactional
    public void purchase(String userId, String commodityCode, Integer count) {
        storageFeignClient.deduct(commodityCode, count);
        orderFeignClient.create(userId, commodityCode, count);
    }
}
