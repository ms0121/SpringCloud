package com.liu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.liu.cloud.domain.CommonResult;
import com.liu.cloud.domain.Payment;
import com.liu.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-29 - 10:27
 */

@RestController
@Slf4j
@RequestMapping("consumer")
public class SentinelController {


//    =====================ribbon实现的服务熔断降级：主要使用RestTemplate 进行调用，
//    这样做的不好地方就是不能够向我们使用的接口直接调用的方式，所以推荐使用OpenFeign的调用方式，

    private static final String url = "http://springcloud-nacos-provider";

    @Resource
    private RestTemplate restTemplate;

//    @GetMapping("sql/{id}")
//    public CommonResult  get(@PathVariable("id") Integer id){
//        return restTemplate.getForObject(url + "/sql/"+id, CommonResult.class);
//    }



    @GetMapping("sql/{id}")
//    value = "fallback"注册进入到sentinel的资源名称

//    @SentinelResource(value = "fallback")   //没有配置，既没有熔断，也没有服务降级

    //fallback只负责业务(java)异常,sentinel配置值异常无法处理
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")

    // blockHandler只负责sentinel控制台配置违规,java运行异常无法处理
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")

    // 当前设置之后，既可以处理java异常出现的问题，还可以处理sentinel配置出现的异常的熔断方法，所以推荐使用
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult result = restTemplate.getForObject(url + "/sql/" + id, CommonResult.class);
        if (id == 4) {  // java运行时异常
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }


    //本例是fallback,非法参数异常出现之后调用的方法
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "兜底异常handlerFallback,exception内容  "
                + e.getMessage(), payment);
    }


    //本例是blockHandler，
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(445, "blockHandler-sentinel限流,无此流水: blockException  " + blockException.getMessage(), payment);
    }


    //==================OpenFeign的调用方式，更加像我们业务的调用需求，直接使用对象调用方法===========
    @Resource
    private PaymentService paymentService;
//
    @GetMapping(value = "feign/sql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
        return paymentService.paymentSql(id);
    }
}
