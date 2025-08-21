package com.cloud.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderTbl implements Serializable {
    private Integer id;
    private String userId;
    private String commodityCode;
    private Integer count;
    private Integer money;
}
