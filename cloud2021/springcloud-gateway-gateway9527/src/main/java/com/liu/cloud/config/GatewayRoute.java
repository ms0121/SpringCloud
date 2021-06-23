package com.liu.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-06-23 - 8:15
 *
 * 使用配置类的方法实现网关配置信息，不需要都写到yml配置文件中
 */

@Configuration
public class GatewayRoute {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        /**
         * 当前的配置意思是：
         * routes:相当于配置文件的routes
         * route参数解释：
         *      id：相当于配置文件的id
         *      lambda：表达式，/guonei (访问网址：http://localhost:9527)
         *              将会转到实际的访问地址: http://news.baidu.com/guonei
         *
         */
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("route1", r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei"))
                .build();

        return routes.build();
    }


    @Bean
    public RouteLocator routeLocator2(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("route1", r -> r.path("/guoji")
                .uri("http://news.baidu.com/guoji"))
                .build();

        return routes.build();
    }


}
