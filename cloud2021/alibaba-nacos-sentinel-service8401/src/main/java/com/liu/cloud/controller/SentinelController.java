package com.liu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-06-26 - 8:42
 */

@RestController
public class SentinelController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("port")
    public String port(){
        return serverPort;
    }

    /**
     * 资源名：唯一名称。默认是请求路径
     * 针对来源：sentinel可以针对调用者进行限流，填写微服务名，默认是default
     *
     * 阈值类型/单机阈值：
     *      QPS(每秒钟的请求数量):当调用该spi的QPS达到阈值的时候，进行限流
     *      线程数：当调用该api的线程数达到阈值的时候，进行限流
     *
     * 是否集群：不需要集群
     * 流控模式：
     *      直接：api达到限流的条件时，直接限流
     *      关联：当关联的资源达到阈值时，就限流自己
     *      链路：只记录指定链路上的流量(指定资源从入口资源进来的流量，如果达到
     *          阈值，就进行限流)[api级别的针对来源]
     *
     * 流控效果：
     *      快速失败：直接失败
     *      warm up：根据codeFactor(冷加载因子)的值，从阈值/codeFactor,经过预热时长，
     *              才达到设置的QPS阈值
     *
     * @return
     */
    @GetMapping("testA")
    public String testA(){
        //
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "testA + port: " + serverPort;
    }

    @GetMapping("testB")
    public String testB(){
        return "testB + port: " + serverPort;
    }



}
