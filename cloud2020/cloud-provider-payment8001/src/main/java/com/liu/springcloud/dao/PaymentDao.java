package com.liu.springcloud.dao;

import com.liu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lms
 * @date 2021-06-02 - 17:45
 */
@Mapper
public interface PaymentDao {
    // 插入数据
    public int create(Payment payment);

    // 读数据
    public Payment getPaymentById(@Param("id") Long id);
}
