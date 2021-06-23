package com.liu.cloud.controller;

import com.liu.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-22 - 8:43
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    //=========== 服务降级

    @GetMapping("payment/hystrix/payment_info/{id}")
    public String payment_info(@PathVariable("id") Integer id){
        return paymentService.payment_info(id);
    }

    @GetMapping("payment/hystrix/payment_timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        return paymentService.payment_timeout(id);
    }



    // ===================服务熔断机制
    @GetMapping("payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String s = paymentService.paymentCircuitBreaker(id);
        log.info("==========info: " + s);
        return s;
    }

}
