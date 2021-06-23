package com.liu.cloud.service;

/**
 * @author lms
 * @date 2021-06-22 - 8:37
 */
public interface PaymentService {

    public String payment_info(Integer id);

    public String payment_timeout(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
