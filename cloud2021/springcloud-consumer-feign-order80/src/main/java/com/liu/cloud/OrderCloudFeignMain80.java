package com.liu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lms
 * @date 2021-06-21 - 18:23
 *
 * 使用OpenFeign需要在客户端里面，编写相应的业务接口类（service），并加上相应的@FeignClient()注解
 */

@SpringBootApplication
@EnableFeignClients  // 需要使用OpenFeign，所以将其进行激活
public class OrderCloudFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderCloudFeignMain80.class, args);
    }
}
