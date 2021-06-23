package com.liu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-21 - 15:06
 */

@RestController
@Slf4j
public class OrderController {

    // 使用RestTemplate的方式调用微服务
    private static final String INVOKE_URL = "http://springcloud-payment-service";

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/zk")
    public String getServerPort(){
        System.out.println("serverPort = " + serverPort);
        // 调用微服务的具体应用，以及调用该微服务的返回值类型
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }




}
