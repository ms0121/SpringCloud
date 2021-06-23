package com.liu.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lms
 * @date 2021-06-16 - 18:55
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   // 负载均衡必须开启，否则出错
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
