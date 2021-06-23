package com.liu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-06-13 - 18:44
 */
@RestController
@RefreshScope   // 支持nacos的动态刷新操作
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("config/info")
    public String getConfig(){
        return configInfo;
    }
}








