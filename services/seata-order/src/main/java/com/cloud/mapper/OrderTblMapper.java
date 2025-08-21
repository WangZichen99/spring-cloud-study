package com.cloud.mapper;

import com.cloud.bean.OrderTbl;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTblMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderTbl record);

    int insertSelective(OrderTbl record);

    OrderTbl selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderTbl record);

    int updateByPrimaryKey(OrderTbl record);
}
