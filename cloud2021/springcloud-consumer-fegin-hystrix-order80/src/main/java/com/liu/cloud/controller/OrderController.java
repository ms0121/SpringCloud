package com.liu.cloud.controller;

import com.liu.cloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-22 - 9:35
 */

@RestController
@Slf4j
@RequestMapping("consumer")
//全局异常服务降级方法
@DefaultProperties(defaultFallback = "globalError")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("payment/hystrix/payment_info/{id}")
    public String payment_info(@PathVariable("id") Integer id){
        return orderService.payment_info(id);
    }

    // 指定使用具体的服务降级方法error
//    @HystrixCommand(fallbackMethod = "error", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })

    @HystrixCommand   // 出现异常，将会调用全局的服务降级方法
    @GetMapping("payment/hystrix/payment_timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        return orderService.payment_timeout(id);
    }

    // 局部的服务降级方法
    public String error(@PathVariable("id") Integer id){
        return "我是消费者80端，sorry，系统出现了异常，请10秒后再试~~~~~~";
    }

    // 全局的服务降级方法
    public String globalError(){
        return "Global全局异常处理，系统出现了异常了，请10秒后再试!~~~~~";
    }

}
