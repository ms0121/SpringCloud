package com.liu.springcloud.alibaba.service;

import com.liu.springcloud.entities.CommenResult;
import com.liu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lms
 * @date 2021-06-16 - 18:56
 */

// feign = 接口 + 注解， value表示调用的微服务，调用业务出错的兜底方法： fallback
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/paymentSql/{id}")
    public CommenResult<Payment> paymentSql(@PathVariable("id") Long id);
}
