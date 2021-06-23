package com.liu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-06-21 - 17:21
 *
 * ribbon默认使用的负载均衡算法是轮训算法，如果需要自定义，则需要在cloud包外面的包下进行中自定义
 * 然后再主启动程序中进行设置: @RibbonClient
 */

@Configuration
public class SelfRule {

    @Bean
    public IRule iRule(){
        // 随机的均衡算法
        return new RandomRule();
    }

}
