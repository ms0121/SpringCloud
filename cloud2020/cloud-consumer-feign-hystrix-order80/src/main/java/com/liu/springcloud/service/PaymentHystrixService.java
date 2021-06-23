package com.liu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lms
 * @date 2021-06-06 - 20:27
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)   // 表示使用当前的这个微服务
public interface PaymentHystrixService {

    // 使用上述微服务的具体的功能方法
    @GetMapping("payment/hystrix/ok/{id}")
    public String paymenInfo(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/timeout/{id}")
    public String paymenInfoTimeOut(@PathVariable("id") Integer id);

}
