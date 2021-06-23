package com.liu.cloud.controller;

import com.liu.cloud.domain.CommonResult;
import com.liu.cloud.domain.Payment;
import com.liu.cloud.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-21 - 18:31
 */

@RestController
@Slf4j
public class FeignController {

    @Resource
    private FeignService feignService;

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return feignService.getPayment(id);
    }

    @GetMapping("payment/feign/timeout")
    public String getTimeout(){
        return feignService.getTimeout();

    }

}
