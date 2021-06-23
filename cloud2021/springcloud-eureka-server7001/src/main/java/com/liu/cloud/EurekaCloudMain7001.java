package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lms
 * @date 2021-06-20 - 11:51
 */

@SpringBootApplication
@EnableEurekaServer  // 表示当前的微服务是一个服务注册中心
public class EurekaCloudMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaCloudMain7001.class, args);
    }
}
