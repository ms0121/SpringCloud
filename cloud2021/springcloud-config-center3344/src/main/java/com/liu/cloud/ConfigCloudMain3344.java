package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author lms
 * @date 2021-06-24 - 21:48
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCloudMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCloudMain3344.class, args);
    }
}
