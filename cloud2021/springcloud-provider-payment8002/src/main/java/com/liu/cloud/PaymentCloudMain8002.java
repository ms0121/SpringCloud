package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lms
 * @date 2021-06-20 - 18:17
 */

@SpringBootApplication
@EnableEurekaClient  // 生产者提供微服务，并将微服务注册到注册中心里面
@EnableDiscoveryClient // 开启服务发现的功能
public class PaymentCloudMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentCloudMain8002.class, args);
    }
}
