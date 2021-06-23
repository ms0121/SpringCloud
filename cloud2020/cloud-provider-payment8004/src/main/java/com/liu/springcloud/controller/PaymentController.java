package com.liu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lms
 * @date 2021-06-04 - 20:42
 */
@RestController
@Slf4j
public class PaymentController {

    // 获取配置文件中指定的值
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "zk: " + serverPort + "\t" + UUID.randomUUID().toString();
    }


}
