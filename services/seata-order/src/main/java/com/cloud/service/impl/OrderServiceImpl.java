package com.cloud.service.impl;

import com.cloud.bean.OrderTbl;
import com.cloud.feign.AccountFeignClient;
import com.cloud.mapper.OrderTblMapper;
import com.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderTblMapper orderTblMapper;

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Override
    @Transactional()
    public OrderTbl create(String userId, String commodityCode, Integer count) {
        Integer money = 9 * count;
        accountFeignClient.debit(userId, money);
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUserId(userId);
        orderTbl.setCommodityCode(commodityCode);
        orderTbl.setCount(count);
        orderTbl.setMoney(money);
        orderTblMapper.insert(orderTbl);
        return orderTbl;
    }
}
