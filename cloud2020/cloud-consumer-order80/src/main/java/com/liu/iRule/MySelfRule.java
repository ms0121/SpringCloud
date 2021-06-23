package com.liu.iRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-06-05 - 19:44
 *
 * 默认eureka使用的是轮询的负载访问方式
 *  可以创建一个不在主启动类下的类，进行更新负载均衡使用的方法
 */

@Configuration  // 标志位配置类
public class MySelfRule {

    @Bean
    public IRule iRule(){
        // 定义为随机的方式
        return new RandomRule();
    }
}
