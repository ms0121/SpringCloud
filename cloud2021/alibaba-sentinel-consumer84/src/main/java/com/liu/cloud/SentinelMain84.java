package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lms
 * @date 2021-06-29 - 10:26
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SentinelMain84 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain84.class, args);
    }
}
