package com.liu.cloud.dao;

import com.liu.cloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lms
 * @date 2021-06-29 - 21:33
 */

@Mapper  // 扫描当前的dao包
public interface OrderDao {

    void create(Order order);

    void update(@Param("userId") String userId, @Param("status") Integer status);
}
