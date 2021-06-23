package com.liu.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lms
 * @date 2021-06-20 - 2:50
 */

@Data
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
