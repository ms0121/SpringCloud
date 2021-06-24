package com.liu.cloud.service.impl;

import com.liu.cloud.service.MessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author lms
 * @date 2021-06-24 - 11:56
 */
//该注解的作用就是将信道channel和exchange绑定，并不是普通的业务类，所以不能添加所谓的@service注解
@EnableBinding(Source.class)   // 定义消息驱动的消息管道
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        // 往消息中间件发送消息
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("===========send===========");
        return null;
    }
}
