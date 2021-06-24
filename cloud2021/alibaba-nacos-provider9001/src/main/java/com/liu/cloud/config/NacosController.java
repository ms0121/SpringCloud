package com.liu.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-06-24 - 22:13
 */

@RestController
public class NacosController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        System.out.println("已经收到了消息........");
        return "已经收到nacos的信息, 端口号是: port = " + serverPort + ", id = " + id ;
    }
}
