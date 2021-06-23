package com.liu.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-06-22 - 11:03
 * 使用实现类的方式实现服务降级的功能，让代码之间实现解耦合，也减少了代码的冗余
 */

@Component  // 必须添加，防止springboot无法进行扫描
public class OrderHystrixService implements OrderService {
    @Override
    public String payment_info(Integer id) {
        return "payment_info 出现了异常的现象，请重新进行尝试~~~~~~";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "payment_timeout 出新了异常的现象，请重新的评估后再试~!!!";
    }
}
