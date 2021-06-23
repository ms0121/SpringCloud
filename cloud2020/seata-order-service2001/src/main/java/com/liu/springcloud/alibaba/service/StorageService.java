package com.liu.springcloud.alibaba.service;

import com.liu.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lms
 * @date 2021-06-18 - 11:34
 */

// 表示调用的具体的微服务名称，
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    // 表示调用的具体的微服务中的具体的应用
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("produceId") Long productId, @RequestParam("count") Integer count);
}
