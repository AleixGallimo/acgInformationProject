package com.qf.acgInformation.service;

import com.qf.acgInformation.entity.Message;
import org.apache.ibatis.annotations.Param;

/**
 * CHAN
 * 2019/12/22 17:29
 */
public interface IMessageService {
    //添加消息 / 添加评论
    Integer addMessage(Message message);

    //删除消息 / 删除评论
    Integer deleteMessage(Integer messageId);
}
