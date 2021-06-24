package com.liu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-06-24 - 23:09
 */

@RestController
@Slf4j
public class NacosConfigController {

    // ${config.info}：读取的信息是nacos上面进行配置的信息
    @Value("${config.info}")
    private String configInfo;


    @GetMapping("config/info")
    public String getConfig(){
        return configInfo;
    }

}
