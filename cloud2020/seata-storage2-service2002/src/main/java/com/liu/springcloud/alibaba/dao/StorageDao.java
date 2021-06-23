package com.liu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lms
 * @date 2021-06-18 - 19:30
 */
@Mapper
public interface StorageDao {
    void decrease(@RequestParam("produceId") Long productId, @RequestParam("count") Integer count);
}
