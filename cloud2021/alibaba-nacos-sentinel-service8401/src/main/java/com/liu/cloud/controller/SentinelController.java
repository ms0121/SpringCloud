package com.liu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-06-26 - 8:42
 */

@RestController
@Slf4j
public class SentinelController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("port")
    public String port() {
        return serverPort;
    }

    /**
     * 资源名：唯一名称。默认是请求路径
     * 针对来源：sentinel可以针对调用者进行限流，填写微服务名，默认是default
     * <p>
     * 阈值类型/单机阈值：
     * QPS(每秒钟的请求数量):当调用该spi的QPS达到阈值的时候，进行限流
     * 线程数：当调用该api的线程数达到阈值的时候，进行限流
     * <p>
     * 是否集群：不需要集群
     * 流控模式：
     * 直接：api达到限流的条件时，直接限流
     * 关联：当关联的资源达到阈值时，就限流自己
     * 链路：只记录指定链路上的流量(指定资源从入口资源进来的流量，如果达到
     * 阈值，就进行限流)[api级别的针对来源]
     * <p>
     * 流控效果：
     * 快速失败：直接失败
     * warm up：根据codeFactor(冷加载因子)的值，从阈值/codeFactor,经过预热时长，
     * 才达到设置的QPS阈值（意思就是：设置单击阈值是10，刚开始可以接受10/3的请求量，
     * 经过系统的慢慢请求，5秒之后可以每秒承受10个请求）
     * 应用场景：秒杀系统的在开启的瞬间，会有很多的流量上来，很有可能会将系统打死，
     * 预热方式就是为了保护系统，可以慢慢的把阈值增长到设置的阈值
     * 排队等待：就是匀速排队，让请求以均匀的速度通过，阈值类型必须设置为QPS，否则无效
     * 设置含义：/testA每秒1次请求，超过的话就得排队，等待的时间为指定的超时时间
     * <p>
     * 降级规则：
     * RT：平均响应时间，秒级
     * 平均响应时间，超出阈值 并且在时间窗口内通过的请求数 >= 5,两个条件满足后出发降级服务，
     * 窗口期结束之后关闭断路器，RT最大数是4900，更大的可以进行修改
     * <p>
     * 异常比例（秒级）：
     * QPS >= 5,并且异常比例(秒级统计)超过阈值时，触发降级，时间窗口期结束之后，关闭降级
     * <p>
     * 异常数(分钟数)
     * 异常数(分钟统计)，超过阈值时，触发降级，时间窗口结束后，关闭降级
     */

    @GetMapping("testA")
    public String testA() {
        //  测试流控规则的 线程数
//        try {
//            TimeUnit.MILLISECONDS.sleep(1500);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        return "testA + port: " + serverPort;
    }


    @GetMapping("testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "......testB");
        return "testB + port: " + serverPort;
    }

    @GetMapping("testD")
    public String testD() {
        //  实现降级规则：该方法处理完成需要一秒钟，后台设置降级规则是一秒处理一个请求
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        int s = 10 / 0;
        return "testD + port: " + serverPort;
    }


}
