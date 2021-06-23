package com.liu.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lms
 * @date 2021-06-18 - 19:31
 */

public interface StorageService {
    void decrease(@RequestParam("produceId") Long productId, @RequestParam("count") Integer count);
}
