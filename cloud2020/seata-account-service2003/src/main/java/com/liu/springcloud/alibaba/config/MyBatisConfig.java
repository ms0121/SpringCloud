package com.liu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-06-18 - 19:07
 */

@Configuration
@MapperScan({"com.liu.springcloud.alibaba.dao"})
public class MyBatisConfig {

}
