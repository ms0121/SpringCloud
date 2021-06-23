package com.liu.springcloud.controller;

import com.liu.springcloud.entities.CommenResult;
import com.liu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-03 - 15:38
 */
@RestController
@Slf4j
public class OrderController {

    // 服务提供者的网址  单机版的访问地址
//    private static final String PAYMENT_URL = "http://localhost:8001";

    // 集群的访问地址，访问集群提供的接口
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    // 内部封装了HTTPClient
    @Resource
    private RestTemplate restTemplate;


    // 添加方法
    @GetMapping("/consumer/payment/create")
    public CommenResult<Payment> create(Payment payment){
        // 调用服务提供者(端口号为8001)的 /payment/create 方法，传递的参数，返回结果类型
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",
                payment, CommenResult.class);
    }

    // 查询方法
    @GetMapping("consumer/payment/get/{id}")
    public CommenResult<Payment> getPayment(@PathVariable("id") Long id){
        // 查询方法
        // 返回对象为响应体中数据转化成的对象，基本上可以理解为json
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommenResult.class);
    }

    // 查询方法
    @GetMapping("consumer/payment/getForEntity/{id}")
    public CommenResult<Payment> getForEntity(@PathVariable("id") Long id){
        // 查询方法
        // 返回对象是ResponseEntity对象，包含了响应中的一些重要信息，比如相应头，
        // 响应状态码，响应体等一些详细的信息数据
        ResponseEntity<CommenResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommenResult.class);
        // 响应成功是的code是 200
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        } else {
            return new CommenResult<>(444, "操作失败");
        }
    }

}
















