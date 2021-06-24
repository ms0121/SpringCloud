package com.liu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-24 - 22:33
 */

@RestController
@Slf4j
public class NacosController {

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        // 消费者调用生产者的具体的服务，该服务的返回值的类型
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, String.class);
    }


}
