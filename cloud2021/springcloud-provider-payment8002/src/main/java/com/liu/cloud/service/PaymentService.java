package com.liu.cloud.service;

import com.liu.cloud.domain.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lms
 * @date 2021-06-20 - 2:47
 */

public interface PaymentService {
    // 新增
    public int create(Payment payment);
    // 查询
    public Payment getPayment(@Param("id") Long id);
    //  查询所有的数据信息
    public List<Payment> getAll();

}
