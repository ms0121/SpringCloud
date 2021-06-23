package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lms
 * @date 2021-06-20 - 2:29
 */

@SpringBootApplication
@EnableEurekaClient  // 表示当前的微服务是用来提供服务的，将微服务注册进入到注册中心里面
@EnableDiscoveryClient   // 开启服务的发现功能
public class PaymentCloudMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentCloudMain8001.class, args);
    }
}
