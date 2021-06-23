package com.liu.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lms
 * @date 2021-06-13 - 14:58
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  // 表示使用轮询的负载均衡的方法,因为有多个服务提供者，所以必须使用负载均衡的方法
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
