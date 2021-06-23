package com.liu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;

/**
 * @author lms
 * @date 2021-06-21 - 15:59
 */

@RestController
public class ConsulController {

    private static final String INVOKE_URL = "http://springcloud-providerconsul-payment";

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("consumer/payment/consul")
    public String getServerPort(){
        System.out.println("serverPort = " + serverPort);
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }

}
