package com.cloud.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class StorageTbl implements Serializable {
    private Integer id;
    private String commodityCode;
    private Integer count;
}
