package com.cloud.service;

import com.cloud.bean.OrderTbl;

public interface OrderService {
    OrderTbl create(String userId, String commodityCode, Integer count);
}
