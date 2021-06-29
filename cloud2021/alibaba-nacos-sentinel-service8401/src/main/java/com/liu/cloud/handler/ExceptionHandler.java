package com.liu.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.liu.cloud.domain.CommonResult;

/**
 * @author lms
 * @date 2021-06-29 - 9:31
 */
public class ExceptionHandler {

    // 参数一定要配置BlockException
    public static CommonResult ex1(BlockException ex){
        return new CommonResult(4444,"访问失败， ex1()-----------1");
    }

    public static CommonResult ex2(BlockException ex){
        return new CommonResult(4444,"访问失败， ex2()-----------2");
    }
}
