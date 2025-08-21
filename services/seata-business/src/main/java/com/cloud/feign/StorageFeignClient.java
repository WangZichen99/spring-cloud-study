package com.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage", path = "/storage")
public interface StorageFeignClient {
    @GetMapping("/deduct")
    String deduct(@RequestParam("commodityCode") String commodityCode,
                  @RequestParam("count") Integer count);
}
