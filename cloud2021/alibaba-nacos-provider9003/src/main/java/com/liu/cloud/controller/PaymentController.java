package com.liu.cloud.controller;

import com.liu.cloud.domain.CommonResult;
import com.liu.cloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author lms
 * @date 2021-06-29 - 10:10
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    // 静态代码块,随着类的加载而执行一次
    static {
        hashMap.put(1L,new Payment(1L,"28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L,new Payment(2L,"bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3L,new Payment(3L,"6ua8c1e3bc2742d8848569891xt92183"));
    }


    @GetMapping("sql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        return new CommonResult<>(200,"from mysql,serverPort:  "+serverPort,payment);
    }
}
