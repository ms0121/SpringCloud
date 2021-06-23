package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lms
 * @date 2021-06-20 - 13:57
 */

@SpringBootApplication
@EnableEurekaServer  // Eureka服务注册中心
public class EurekaCloudMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaCloudMain7002.class, args);
    }
}
