package com.liu.springcloud.controller;

import com.liu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-06 - 19:58
 */
@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("hystrix/ok/{id}")
    public String paymenInfo(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo(id);
        log.info("*******result: " + result);
        return result;
    }

    @GetMapping("hystrix/timeout/{id}")
    public String paymenInfoTimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentTimeOut(id);
        log.info("*******result: " + result);
        return result;
    }


    /**
     * 服务熔断的测试案例
     * @param id
     * @return
     */
    @GetMapping("hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}














