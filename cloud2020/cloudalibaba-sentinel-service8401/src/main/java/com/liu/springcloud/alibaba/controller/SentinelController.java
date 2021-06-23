package com.liu.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-06-14 - 10:08
 */

@RestController
public class SentinelController {

    @GetMapping("testA")
    public String testA(){
        return "==========testA";
    }


    @GetMapping("testB")
    public String testB(){
        return "==========testB";
    }
}
