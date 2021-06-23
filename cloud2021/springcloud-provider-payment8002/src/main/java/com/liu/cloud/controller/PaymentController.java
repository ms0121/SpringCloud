package com.liu.cloud.controller;

import com.liu.cloud.domain.CommonResult;
import com.liu.cloud.domain.Payment;
import com.liu.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lms
 * @date 2021-06-20 - 2:52
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    // 被远程调用，所以要求是post的方式
    @PostMapping("payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("**********插入的结果: " + i);
        if (i > 0){
            return new CommonResult<Integer>(200, "添加成功！port: " + serverPort, i);
        }else {
            return new CommonResult<Integer>(404, "添加失败,请重试！", i);
        }

    }

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPayment(id);
        log.info("**********查询的结果: " + payment);
        return new CommonResult<Payment>(200, "查询成功! port: " + serverPort, payment);
    }

    @GetMapping("payment/lb")
    public String getServerPort(){
        return "当前访问的微服务端口号是: " + serverPort;
    }


    @GetMapping("payment/list")
    public CommonResult<List<Payment>> getAll(){
        List<Payment> payments = paymentService.getAll();
        log.info("==========查询所有的信息： " + payments);
        return new CommonResult<List<Payment>>(200, "查询成功! port: " + serverPort, payments);
    }


    @GetMapping("payment/discovery")
    public CommonResult discovery() {
        // 获取eureka注册中心里面的所有的服务信息
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("************service = " + service);
        }

        // 获取指定的某个服务信息里面的详细信息
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-payment-service");
        for (ServiceInstance instance : instances) {
            // 获取服务的名称，主机，端口号，以及对应的uri地址
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t"
                    + instance.getPort() + "\t" + instance.getUri());
        }
        return new CommonResult(200, "查询成功!", this.discoveryClient);
    }


}
