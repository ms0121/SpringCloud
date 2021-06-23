package com.liu.springcloud.service;

import com.liu.springcloud.entities.CommenResult;
import com.liu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lms
 * @date 2021-06-06 - 15:03
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
//标识当前的接口是一个OpenFeign的接口类型
// value表示当前要调用的是具体的那个微服务，
public interface PaymentFeignService {

    // 调用上面指定的微服务的地址对应的方法
    @GetMapping("/payment/get/{id}")
    public CommenResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeOut();
}
