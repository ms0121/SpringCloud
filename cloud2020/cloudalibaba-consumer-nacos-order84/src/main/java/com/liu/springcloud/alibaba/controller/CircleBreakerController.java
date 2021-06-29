package com.liu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.liu.springcloud.alibaba.service.PaymentService;
import com.liu.springcloud.entities.CommenResult;
import com.liu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-16 - 19:03
 */

@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")   //没有配置
    @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务(java)异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
//            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommenResult<Payment> fallback(@PathVariable Long id) {
        CommenResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSql/" + id, CommenResult.class, id);

        if (id == 4) {  // java运行时异常
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    //本例是fallback,访问的地址出现异常之后调用的方法
    public CommenResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommenResult<>(444, "兜底异常handlerFallback,exception内容  " + e.getMessage(), payment);
    }


    //本例是blockHandler，
    public CommenResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommenResult<>(445, "blockHandler-sentinel限流,无此流水: blockException  " + blockException.getMessage(), payment);
    }


    //==================OpenFeign===========
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSql/{id}")
    public CommenResult<Payment> paymentSql(@PathVariable("id") Long id) {
        return paymentService.paymentSql(id);
    }

}
