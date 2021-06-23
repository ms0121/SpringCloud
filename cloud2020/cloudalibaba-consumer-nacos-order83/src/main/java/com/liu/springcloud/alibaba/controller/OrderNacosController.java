package com.liu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-13 - 15:00
 */

@RestController
@Slf4j
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    // 调用的微服务名称
    @Value("${service-url.nacos-user-service}")
    private String serverUrl;


    @GetMapping(value = "consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        // 消费者调用生产者的具体的服务，该服务的返回值的类型
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, String.class);
    }


}
