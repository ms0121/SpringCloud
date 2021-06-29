package com.liu.cloud.service;

import com.liu.cloud.domain.CommonResult;
import com.liu.cloud.domain.Payment;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-06-29 - 11:40
 */
@Component   // 一定要将当前的类注入到容器当中
public class PaymentServiceImpl implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(4040404,"error page!", new Payment(390L, "null serial!"));
    }
}
