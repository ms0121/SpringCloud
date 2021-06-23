package com.liu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author lms
 * @date 2021-06-18 - 18:51
 */

@Mapper
public interface AccountDao {
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
