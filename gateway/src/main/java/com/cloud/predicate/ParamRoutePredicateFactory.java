package com.cloud.predicate;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class ParamRoutePredicateFactory extends AbstractRoutePredicateFactory<ParamRoutePredicateFactory.Config> {

    public ParamRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        // 配置参数顺序
        return Arrays.asList("param", "value");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                // 返回true表示命中断言，返回false未命中
                String param = serverWebExchange.getRequest().getQueryParams().getFirst(config.param);
                return StringUtils.hasText(param) && param.equals(config.value);
            }
        };
    }

    @Validated
    public static class Config {
        private @NotEmpty String param;
        private String value;

        public Config() {
        }

        public String getParam() {
            return this.param;
        }

        public Config setParam(String param) {
            this.param = param;
            return this;
        }

        public String getValue() {
            return this.value;
        }

        public Config setValue(String value) {
            this.value = value;
            return this;
        }
    }
}
