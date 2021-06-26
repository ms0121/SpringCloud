package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lms
 * @date 2021-06-26 - 8:41
 */

@SpringBootApplication
@EnableDiscoveryClient   // 使用到了注册中心nacos，需要打开注册发现
public class SentinelCloudMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelCloudMain8401.class, args);
    }
}
