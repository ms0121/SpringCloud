package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lms
 * @date 2021-06-29 - 10:13
 */

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain9003.class, args);
    }
}
