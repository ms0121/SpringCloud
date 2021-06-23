package com.liu.springcloud.alibaba.controller;

import com.liu.springcloud.alibaba.domain.CommonResult;
import com.liu.springcloud.alibaba.domain.Order;
import com.liu.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-18 - 13:22
 */

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功!");
    }

}
