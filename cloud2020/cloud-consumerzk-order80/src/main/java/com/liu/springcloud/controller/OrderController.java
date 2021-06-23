package com.liu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-04 - 21:16
 */

@RestController
@Slf4j
public class OrderController {

    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @GetMapping("consumer/payment/zk")
    public String paymentInfo(){
        // 消费端从注册中心获取指定的服务，再或者该服务中的某个具体的应用，
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }

    @Resource
    private RestTemplate restTemplate;

}
