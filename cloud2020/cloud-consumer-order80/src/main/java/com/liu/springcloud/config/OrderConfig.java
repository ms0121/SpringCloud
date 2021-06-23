package com.liu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lms
 * @date 2021-06-03 - 15:45
 */

@Configuration
public class OrderConfig {

    @Bean
    @LoadBalanced  // 开启集群的负载均衡的方式进行读取
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
