package com.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-account", path = "/account")
public interface AccountFeignClient {
    @GetMapping("/debit")
    public String debit(@RequestParam("userId") String userId,
                        @RequestParam("money") Integer money);
}
