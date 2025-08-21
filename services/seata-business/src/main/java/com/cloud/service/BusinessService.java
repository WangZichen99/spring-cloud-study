package com.cloud.service;

public interface BusinessService {
    void purchase(String userId, String commodityCode, Integer count);
}
