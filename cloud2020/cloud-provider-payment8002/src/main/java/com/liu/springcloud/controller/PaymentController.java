package com.liu.springcloud.controller;

import com.liu.springcloud.entities.CommenResult;
import com.liu.springcloud.entities.Payment;
import com.liu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-02 - 18:18
 */
@RestController    // 包括了Controller + ResponseBody
@Slf4j     // 对应日记
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    // @RequestBody可以将body里面所有的json数据传到后端，后端再进行解析,因为当前的参数来源于消费者，
    // 使用的是json进行传递数据
    @PostMapping("create")
    public CommenResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入数据******" + result);
        if (result > 0){
            return new CommenResult(200, "数据插入成功: port = " + serverPort, result);
        } else {
            return new CommenResult(444, "数据插入失败", result);
        }
    }


    @GetMapping("get/{id}")
    public CommenResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询数据******" + payment);
        if (payment != null){
            return new CommenResult(200, "数据查询成功: port = " + serverPort, payment);
        } else {
            return new CommenResult(444, "数据查询失败", payment);
        }
    }


    @GetMapping("lb")
    public String getServerPort(){
        return serverPort;
    }


}
