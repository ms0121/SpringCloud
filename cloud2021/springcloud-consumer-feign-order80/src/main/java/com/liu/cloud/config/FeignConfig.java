package com.liu.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-06-21 - 23:06
 */
@Configuration
public class FeignConfig {

    // 开启Feign的日志功能
    @Bean
    public Logger.Level feignLoggerLavel(){
        return Logger.Level.FULL;
    }
}
