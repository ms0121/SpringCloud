package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lms
 * @date 2021-06-21 - 15:57
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderCloudConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderCloudConsulMain80.class, args);
    }
}
