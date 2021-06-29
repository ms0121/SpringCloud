package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lms
 * @date 2021-06-29 - 10:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain9004 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain9004.class, args);
    }
}
