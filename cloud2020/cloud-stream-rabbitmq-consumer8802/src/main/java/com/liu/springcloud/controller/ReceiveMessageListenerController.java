package com.liu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-06-13 - 10:20
 */

@Component
@EnableBinding(Sink.class)   // 将信道进行绑定，即绑定到指定的交换机上面，消费者为Sink
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private Integer serverPort;

    /**
     * 接收来自生产者发布的消息
     * @param message
     */
    @StreamListener(Sink.INPUT)   // 监听端
    public void input(Message<String> message){
        System.out.println("消费者1号, 接收到的消息是: " + message.getPayload()
                + "\t port: " + serverPort);
    }

}
