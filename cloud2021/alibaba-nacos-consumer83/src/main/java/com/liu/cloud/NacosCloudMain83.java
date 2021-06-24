package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lms
 * @date 2021-06-24 - 22:32
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosCloudMain83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosCloudMain83.class, args);
    }
}
