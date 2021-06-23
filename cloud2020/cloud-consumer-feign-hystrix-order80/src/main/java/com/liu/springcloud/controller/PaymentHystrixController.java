package com.liu.springcloud.controller;

import com.liu.springcloud.service.PaymentHystrixService;
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
 * @date 2021-06-06 - 20:30
 */
@RestController
@Slf4j
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    // 实现远程调用微服务的具体方法
    @GetMapping("payment/hystrix/ok/{id}")
    public String paymenInfo(@PathVariable("id") Integer id){
        return paymentHystrixService.paymenInfo(id);
    }

    @GetMapping("payment/hystrix/timeout/{id}")
//    使用指定的 fallbackMethod 方法
//    @HystrixCommand(fallbackMethod = "paymentTimeOutInfo",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
//    })

    @HystrixCommand
    public String paymenInfoTimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.paymenInfoTimeOut(id);
    }

    public String paymentTimeOutInfo(@PathVariable("id") Integer id){
        return "我是客户端80端口，太久了，等不及了，我先走了!参数是： " + id;
    }

    // 全局fallbackMethod函数，意思就是没有配置fallbackMethod函数的默认使用全局的
    public String payment_global_fallbackMethod(){
        return "Global全局的fallbackMethod函数，每个人都可以进行调用--------------";
    }


}
