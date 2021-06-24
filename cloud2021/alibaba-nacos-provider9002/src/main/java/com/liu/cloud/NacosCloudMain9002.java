package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lms
 * @date 2021-06-24 - 22:21
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosCloudMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosCloudMain9002.class, args);
    }
}
