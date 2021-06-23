package com.liu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-06-10 - 22:00
 */
@Configuration
public class GateWayConfig {

    // 自配置一个gateway的配置类
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        // 获取routes，相当于yml中的routes
        RouteLocatorBuilder.Builder routes = builder.routes();
        /**
         * 配置路径
         * path_rout_1:路由的唯一id
         * /guonei： 访问http://localhost:9527/guonei ---> 跳转到： http://news.baidu.com/guonei
         */
        routes.route("path_route_1",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator routeLocator2(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_2",
                r->r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }

}
