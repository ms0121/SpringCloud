package com.liu.cloud.config;

/**
 * @author lms
 * @date 2021-06-20 - 3:45
 */

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced  // 该注解的使用赋予了RestTemplate负载均衡的能力，默认使用轮询的方法
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
