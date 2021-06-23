package com.liu.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.liu.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-06-22 - 8:39
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    //    ===============服务降级

    @Override
    public String payment_info(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "\t payment_info, " + "O(∩_∩)O哈哈~";
    }

    // 给当前的服务提供服务降级的方法:实际就是调用该方法出现问题，调用一个有好的页面告知用户,
    // 设置3秒内是正常返回的，超过3秒将会使用服务降级的方法执行,实现对服务端的访问保护
    @HystrixCommand(fallbackMethod = "error", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String payment_timeout(Integer id) {
    //        异常方案也可以直接使用服务降级的方法
    //        int sum = 10 / 0;

        int number = 1;
        // 设置超时3秒钟
        try {
            TimeUnit.SECONDS.sleep(number);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + "\t payment_timeout, " + "耗时: " + number;
    }

    // 作为服务降级的方法必须是方法的类型，形参必须一致，除了方法名可以不一致之外
    public String error(Integer id){
        return "sorry, 系统出现了异常，请稍后再试!~~~";
    }




    // =========================服务熔断的实现
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    // 服务降级的方法
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }








}
