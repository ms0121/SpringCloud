package com.liu.springcloud;

import com.liu.iRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author lms
 * @date 2021-06-03 - 15:34
 */

@SpringBootApplication
@EnableEurekaClient  // 将消费者也注册进入注册中心

// 表示使用的是自定义的负载均衡的方法，使用随机的均衡算法
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
