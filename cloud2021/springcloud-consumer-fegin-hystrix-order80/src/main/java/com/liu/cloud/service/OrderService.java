package com.liu.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lms
 * @date 2021-06-22 - 9:31
 */
@Component  // 注入容器中
// 调用的微服务名称
// 为了更方便的使用服务降级方法，看起来更加的优雅，实现代码之间的解耦合，我们可以使用当前service接口的实现类来实现
// fallback:要使用服务降级的fallback，必须在配置文件里面开启： fallbackfactory属性值
@FeignClient(value = "springcloud-payment-hystrix-service", fallback = OrderHystrixService.class)
public interface OrderService {

    @GetMapping("payment/hystrix/payment_info/{id}")
    public String payment_info(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/payment_timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id);

}
