package com.liu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lms
 * @date 2021-06-02 - 17:40
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
// T 泛型，传回当前泛型类型的对象数据
public class CommenResult<T> {
    private Integer code;
    private String message;
    private T data;

    // 可能没有对应的泛型类型
    public CommenResult(Integer code, String message) {
        this(code, message, null);
    }
}
