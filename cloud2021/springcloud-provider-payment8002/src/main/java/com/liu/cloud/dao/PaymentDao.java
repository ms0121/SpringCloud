package com.liu.cloud.dao;

import com.liu.cloud.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lms
 * @date 2021-06-20 - 2:30
 */

@Mapper
public interface PaymentDao {
    // 插入数据
    public int create(Payment payment);

    // 读数据
    public Payment getPayment(@Param("id") Long id);

    // 查询所有的数据信息
    public List<Payment> getAll();

}
