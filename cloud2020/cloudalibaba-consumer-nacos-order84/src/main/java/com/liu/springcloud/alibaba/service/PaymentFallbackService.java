package com.liu.springcloud.alibaba.service;

import com.liu.springcloud.entities.CommenResult;
import com.liu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @author lms
 * @date 2021-06-16 - 18:59
 */
@Service   // 必将将该类注入到容器中
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommenResult<Payment> paymentSql(Long id) {
        return new CommenResult<>(44444, "服务降级返回,---PaymentFallbackService",
                new Payment(id, "errorSerial"));
    }
}
