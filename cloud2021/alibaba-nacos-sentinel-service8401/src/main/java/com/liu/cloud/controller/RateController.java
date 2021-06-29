package com.liu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.liu.cloud.domain.CommonResult;
import com.liu.cloud.domain.Payment;
import com.liu.cloud.handler.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-06-29 - 9:00
 */

@RestController
@Slf4j
public class RateController {

    // 按照资源名称进行限流
    @GetMapping("/getResources")
    // 按照资源名称进行访问，如果出现异常，直接使用指定的blockHandler降级方法，没写blockHandler定义的方法，
    // 就使用系统自带的降级方法
    @SentinelResource(value = "resource", blockHandler = "getNot")
    public CommonResult get(){
        return new CommonResult(200, "按照资源名称进行限流",new Payment(10000L, "78372873"));
    }
    // 一定要在参数部分添加异常的类
    public CommonResult getNot(BlockException ex){
        return new CommonResult(200, ex.getMessage(),"失败！989");
    }


    // 按照URL进行限流
    @GetMapping("/getUrl")
    // 没写blockHandler定义的方法，就使用系统自带的降级方法
    @SentinelResource(value = "url")
    public CommonResult getUrl(){
        return new CommonResult(200, "按照URL进行限流",new Payment(1001L, "jkdjsks"));
    }


    // 按照自定义的资源进行限流，需要新建一个全局的降级的处理类
    @GetMapping("/limit")
    // 需要指定使用的是哪个类的具体哪个方法
    @SentinelResource(value = "limit",
            blockHandlerClass = ExceptionHandler.class,
            blockHandler = "ex1")
    public CommonResult getLimit(){
        return new CommonResult(200, "自定义方法limit",
                new Payment(2222L, "hdsjkd3232"));
    }


}
