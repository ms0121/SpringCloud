package com.liu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lms
 * @date 2021-06-21 - 14:32
 */

@RestController
@Slf4j
public class ZkController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/zk")
    public String getServerPort(){
        return "zookeeper, port: " + serverPort + "order: " + UUID.randomUUID().toString();
    }

}
