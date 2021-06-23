package com.liu.springcloud.alibaba.dao;

import com.liu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lms
 * @date 2021-06-18 - 10:55
 */

@Mapper
public interface OrderDao {
    // 创建订单
    public void create(Order order);

    // 修改订单的状态
    public void update(@Param("userId") Long userId, @Param("status") Integer status);
}
