package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lms
 * @date 2021-06-21 - 15:05
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkCloudMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkCloudMain80.class, args);
    }
}
