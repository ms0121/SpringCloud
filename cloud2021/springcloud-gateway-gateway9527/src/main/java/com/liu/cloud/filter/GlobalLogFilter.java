package com.liu.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author lms
 * @date 2021-06-23 - 13:09
 *
 * 实现gateway的过滤链，主要应用在微服务的前面，当一个访问请求进来的时候，
 * 首先经过Filter，验证通过可以继续访问，否则会被拒绝访问
 */
@Component
@Slf4j
public class GlobalLogFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("******************filter: " + new Date());

        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null){
            log.info("=======用户名为null，非法用户！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
