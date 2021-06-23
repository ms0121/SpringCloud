package com.liu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author lms
 * @date 2021-06-18 - 19:26
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Storage {
    private Long id;
    private Long product_id;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
