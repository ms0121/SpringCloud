package com.liu.cloud;

import com.liu.myrule.SelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
/**
 * @author lms
 * @date 2021-06-20 - 3:50
 */

@SpringBootApplication
@EnableEurekaClient  // 开启eureka客户端
// 表示给哪个微服务提供自定义的负载均衡算法，使用自定义的SelfRule算法,name：需要大写
@RibbonClient(name = "SPRINGCLOUD-PAYMENT-SERVICE", configuration = SelfRule.class)
public class OrderCloudMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderCloudMain80.class, args);
    }
}
