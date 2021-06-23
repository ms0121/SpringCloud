package com.liu.springcloud.service.impl;

import com.liu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author lms
 * @date 2021-06-12 - 22:08
 */

//该注解的作用就是将信道channel和exchange绑定，所以不需要@service注解
@EnableBinding(Source.class) //定义消息的推送管道  生产者 source
public class MessageProviderImpl implements IMessageProvider
{
    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send()
    {
        String serial = UUID.randomUUID().toString();
        // 将消息进行构建，放入到管道中传输
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return serial;
    }
}

