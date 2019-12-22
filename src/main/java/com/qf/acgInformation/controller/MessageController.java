package com.qf.acgInformation.controller;

import com.qf.acgInformation.entity.Message;
import com.qf.acgInformation.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * CHAN
 * 2019/12/22 17:36
 */
@Slf4j
@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    private IMessageService messageService;

    //发送消息 / 发送评论
    @RequestMapping(value = "/add",method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Integer addMessage(@RequestBody Message message){
        log.debug("message对象为：" + message);
        return messageService.addMessage(message);
    }

    //删除消息 / 删除评论
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    private Integer deleteMessage(Integer messageId){
        log.debug("mid:" + messageId);
        return messageService.deleteMessage(messageId);
    }
}
