package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lms
 * @date 2021-06-23 - 7:56
 *
 * 注意：作为网关，不需要web服务，所以在pom文件中不能够添加web的依赖
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GatewayCloudMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayCloudMain9527.class, args);
    }
}
