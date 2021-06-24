package com.liu.cloud.controller;

import com.liu.cloud.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-06-24 - 12:04
 */

@RestController
@Slf4j
public class MessageController {

    @Resource
    private MessageService messageService;


    @GetMapping("send")
    public String send(){
        messageService.send();
        return "执行完成!";
    }

}
