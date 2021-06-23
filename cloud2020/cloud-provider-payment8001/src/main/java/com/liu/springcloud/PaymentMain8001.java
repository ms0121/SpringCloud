package com.liu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/** * @author lms
 * @date 2021-06-02 - 17:13
 */
@SpringBootApplication
@EnableEurekaClient  // 表示当前的这个模块使用 Eureka 提供服务给注册中心
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
