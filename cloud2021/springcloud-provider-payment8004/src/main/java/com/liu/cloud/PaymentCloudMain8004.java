package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lms
 * @date 2021-06-21 - 14:30
 * 使用zookeeper作为注册中心，必须在pom文件中将原来自带的zookeeper版本进行更换成为虚拟机中安装的版本号
 */

@SpringBootApplication
@EnableDiscoveryClient   // 用到服务注册中心的都需要进行开启服务发现功能
public class PaymentCloudMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentCloudMain8004.class, args);
    }
}
