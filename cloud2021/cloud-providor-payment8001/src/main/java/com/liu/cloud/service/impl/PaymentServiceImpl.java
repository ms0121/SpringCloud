package com.liu.cloud.service.impl;

import com.liu.cloud.dao.PaymentDao;
import com.liu.cloud.domain.Payment;
import com.liu.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lms
 * @date 2021-06-20 - 2:48
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        int i = paymentDao.create(payment);
        return i;
    }

    @Override
    public Payment getPayment(Long id) {
        Payment payment = paymentDao.getPayment(id);
        return payment;
    }

    @Override
    public List<Payment> getAll() {
        return paymentDao.getAll();
    }
}
