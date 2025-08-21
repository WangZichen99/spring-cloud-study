package com.cloud.mapper;

import com.cloud.bean.AccountTbl;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTblMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountTbl record);

    int insertSelective(AccountTbl record);

    AccountTbl selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountTbl record);

    int updateByPrimaryKey(AccountTbl record);

    void debit(String userId, int money);
}
