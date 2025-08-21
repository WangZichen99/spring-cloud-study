package com.cloud.service.impl;

import com.cloud.mapper.AccountTblMapper;
import com.cloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountTblMapper accountTblMapper;

    @Override
    @Transactional()
    public void debit(String userId, Integer money) {
        // 扣减账户余额
        accountTblMapper.debit(userId,money);
    }
}
