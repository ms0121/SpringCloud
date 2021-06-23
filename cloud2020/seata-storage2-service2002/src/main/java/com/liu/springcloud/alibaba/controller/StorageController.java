package com.liu.springcloud.alibaba.controller;

import com.liu.springcloud.alibaba.domain.CommonResult;
import com.liu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-18 - 19:35
 */

@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;


    @RequestMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("produceId") Long productId,
                                 @RequestParam("count") Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200, "库存更新成功!");
    }


}
