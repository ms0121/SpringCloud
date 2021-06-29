package com.liu.cloud.service;

import com.liu.cloud.domain.CommonResult;
import com.liu.cloud.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lms
 * @date 2021-06-29 - 11:38
 */
//需要指定调用的具体的微服务名称，以及出现异常之后调用的服务降级的方式
@FeignClient(value = "springcloud-nacos-provider", fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping(value = "sql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);

}
