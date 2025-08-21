package com.cloud.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountTbl implements Serializable {
    private Integer id;
    private String userId;
    private Integer money;
}
