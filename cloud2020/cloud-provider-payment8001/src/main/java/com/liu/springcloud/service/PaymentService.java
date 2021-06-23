package com.liu.springcloud.service;

import com.liu.springcloud.entities.Payment;

/**
 * @author lms
 * @date 2021-06-02 - 18:12
 */
public interface PaymentService {
    // 插入数据
    public int create(Payment payment);

    // 读数据
    public Payment getPaymentById(Long id);
}
