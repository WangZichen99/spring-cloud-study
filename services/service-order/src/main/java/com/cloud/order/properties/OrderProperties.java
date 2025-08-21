package com.cloud.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "order") //批量绑定无需@RefreshScope就能实现自动刷新
public class OrderProperties {
    private String timeout;
    private String autoConfirm;
    private String dbUrl;
}
