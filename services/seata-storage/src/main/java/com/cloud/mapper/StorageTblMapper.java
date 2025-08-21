package com.cloud.mapper;

import com.cloud.bean.StorageTbl;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageTblMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StorageTbl record);

    int insertSelective(StorageTbl record);

    StorageTbl selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StorageTbl record);

    int updateByPrimaryKey(StorageTbl record);

    void deduct(String commodityCode, int count);
}
