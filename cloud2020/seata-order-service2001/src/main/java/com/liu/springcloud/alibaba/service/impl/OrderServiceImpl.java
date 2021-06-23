package com.liu.springcloud.alibaba.service.impl;

import com.liu.springcloud.alibaba.dao.OrderDao;
import com.liu.springcloud.alibaba.domain.Order;
import com.liu.springcloud.alibaba.service.AccountService;
import com.liu.springcloud.alibaba.service.OrderService;
import com.liu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-18 - 11:33
 */

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;


    /**
     * 创建订单 -- 调用库存服务扣减库存 -- 调用账户服务扣减账户余额 -- 修改订单状态
     * 简单说：
     *  下订单 -- 减库存 -- 减余额 -- 改状态
     * @param order
     */
    @Override
    public void create(Order order) {
        log.info("-------------> 开始新建订单");
        orderDao.create(order);

//        扣减库存
        log.info("-------------> 订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------------> 订单微服务开始调用库存，做扣减end");

//        扣减余额
        log.info("-------------> 订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-------------> 订单微服务开始调用账户，做扣减end");

        log.info("-------------> 修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("-------------> 修改订单状态结束");

    }
}



















