package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lms
 * @date 2021-06-22 - 8:36
 * OpenFeign是一个用在客户端的服务调用模块
 * 实现Hystrix的服务降级案例
 */

@SpringBootApplication
@EnableEurekaClient    // 将当前的微服务注册进入到注册中心
@EnableCircuitBreaker   // 开启服务降级的注解
public class HystrixCloudMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixCloudMain8001.class, args);
    }
}
