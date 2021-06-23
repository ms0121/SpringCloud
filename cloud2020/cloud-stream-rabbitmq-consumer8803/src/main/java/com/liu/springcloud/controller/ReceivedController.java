package com.liu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-06-13 - 11:06
 */
@Component
@EnableBinding(Sink.class)
public class ReceivedController {

    @Value("${server.port}")
    private Integer serverPort;

    /**
     * 接收来自生产者发布的消息
     * @param message
     */
    @StreamListener(Sink.INPUT)   // 监听端
    public void input(Message<String> message){
        System.out.println("消费者2号, 接收到的消息是: " + message.getPayload()
                + "\t port: " + serverPort);
    }

}
