package com.cloud.service;

public interface AccountService {
    void debit(String userId, Integer money);
}
