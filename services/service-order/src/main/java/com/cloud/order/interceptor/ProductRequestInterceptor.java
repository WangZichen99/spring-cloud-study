package com.cloud.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.UUID;

@Component
public class ProductRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // if (attributes != null) {
        //     HttpServletRequest request = attributes.getRequest();
        //     String token = request.getHeader("Authorization");
        //     if (token != null && !token.isEmpty()) {
        //         requestTemplate.header("Authorization", token);
        //     }
        // }
        System.out.println("拦截器：" + requestTemplate.feignTarget().url());
        requestTemplate.header("token", UUID.randomUUID().toString());
    }
}
