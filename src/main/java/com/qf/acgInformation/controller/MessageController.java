package com.qf.acgInformation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qf.acgInformation.entity.Message;
import com.qf.acgInformation.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    //根据用户id获取所有消息
    @RequestMapping(value = "/getMessage")
    private String getMessageByUid(Integer userId){
        List<Message> list = messageService.getMessageByUid(userId);
        return JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
    }

    //删除消息 / 删除评论
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    private Integer deleteMessage(Integer messageId){
        log.debug("mid:" + messageId);
        return messageService.deleteMessage(messageId);
    }

    //聊天框消息
    @RequestMapping(value = "/getMessageByFid")
    private String getMessageByFid(Integer fUserId, Integer userId){
        List<Message> list = messageService.getMessageByFid(fUserId, userId);
        return JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
    }

    //获取用户所有未读消息
    @RequestMapping(value = "/getNoRead")
    private String getNoReadMessageByUid(Integer userId){
        List<Message> list = messageService.getNoReadMessageByUid(userId);
        return JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
    }
    //获取用户所有未读消息总数
    @RequestMapping(value = "/getNoReadCount")
    private Integer getNoReadMessageCountByUid(Integer userId){
        return messageService.getNoReadMessageCountByUid(userId);
    }

    //获取他对用户所有未读消息总数
    @RequestMapping(value = "/getThisNoReadCount")
    private Integer getThisMessageCount(Integer fUserId, Integer userId){
        return messageService.getThisMessageCount(fUserId, userId);
    }

    //消息已读
    @RequestMapping(value = "/readMessage")
    private void readMessage(Integer fUserId, Integer userId){
        messageService.readMessage(fUserId, userId);
    }
}
