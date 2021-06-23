package com.liu.cloud.service;

import com.liu.cloud.domain.CommonResult;
import com.liu.cloud.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lms
 * @date 2021-06-21 - 18:26
 */
// 必须将其注入容器中
@Component
// 指定调用的微服务，OpenFeign封装了Feign，Feign封装了RestTemplate + Ribbon的方式
@FeignClient(value = "SPRINGCLOUD-PAYMENT-SERVICE")
public interface FeignService {

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id);

    @GetMapping("payment/feign/timeout")
    public String getTimeout();

}
