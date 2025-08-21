package com.cloud.service.impl;

import com.cloud.mapper.StorageTblMapper;
import com.cloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageTblMapper storageTblMapper;

    @Override
    @Transactional()
    public void deduct(String commodityCode, Integer count) {
        storageTblMapper.deduct(commodityCode, count);
        if (Objects.equals(5, count)) {
            throw new RuntimeException("库存不足");
        }
    }
}
