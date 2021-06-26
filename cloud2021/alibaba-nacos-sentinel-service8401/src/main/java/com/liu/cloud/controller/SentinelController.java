package com.liu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-06-26 - 8:42
 */

@RestController
public class SentinelController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("testA")
    public String testA(){
        return "testA + port: " + serverPort;
    }

    @GetMapping("testB")
    public String testB(){
        return "testB + port: " + serverPort;
    }



}
