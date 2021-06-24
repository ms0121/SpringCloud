package com.liu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-06-24 - 15:12
 */

@Component
@EnableBinding(Sink.class)
public class ReceivedController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号，接收到的消息是: " + message + "\t,当前端口号为: " + serverPort);
    }


}
