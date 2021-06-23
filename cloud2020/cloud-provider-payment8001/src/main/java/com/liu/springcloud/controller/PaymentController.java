package com.liu.springcloud.controller;

import com.liu.springcloud.entities.CommenResult;
import com.liu.springcloud.entities.Payment;
import com.liu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    // 对于注册进入eureka里面的微服务，可以通过服务发现来获得服务的信息
    @Resource
    private DiscoveryClient discoveryClient;

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


    @GetMapping("discovery")
    public Object discovery(){
        // 获取eureka注册中心里面的所有的服务信息
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("************service = " + service);
        }

        // 获取指定的某个服务信息里面的详细信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            // 获取服务的名称，主机，端口号，以及对应的uri地址
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t"
                + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }


    // 测试OpenFeign的默认等待时间（1秒）的案例
    // 当前设置了延迟时间是3秒，所以要在客户端进行时间的设置
    @GetMapping("feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }


}
