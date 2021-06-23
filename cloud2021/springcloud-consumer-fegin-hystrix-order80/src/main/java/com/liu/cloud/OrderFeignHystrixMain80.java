package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lms
 * @date 2021-06-22 - 9:29
 * Hystrix的服务降级的实现方式，案例讲解
 */

@SpringBootApplication
@EnableEurekaClient  // 开启Eureka注册中心
@EnableFeignClients  // 激活OpenFeign
@EnableHystrix   // 启用了Hystrix的服务降级方法(一般用在服务端)
public class OrderFeignHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixMain80.class, args);
    }
}
