package com.liu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-06-08 - 17:02
 */
//全局的 服务降级的函数
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymenInfo(Integer id) {
        return "------------paymenInfo--------------";
    }

    @Override
    public String paymenInfoTimeOut(Integer id) {
        return "------------paymenInfoTimeOut--------------";
    }
}
