package com.liu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-06-18 - 14:20
 */

@Configuration
@MapperScan({"com.liu.springcloud.alibaba.dao"})  // 会创建 mapper.xml的代理类
public class MyBatisConfig {

}
