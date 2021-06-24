package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lms
 * @date 2021-06-24 - 22:12
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosCloudMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosCloudMain9001.class, args);
    }
}
