package com.liu.springcloud.alibaba.service;

import com.liu.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author lms
 * @date 2021-06-18 - 11:34
 */

@FeignClient(value = "seata-account-service")
public interface AccountService {

    // 表示调用的具体的微服务中的具体的应用
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
