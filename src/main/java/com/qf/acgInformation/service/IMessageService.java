package com.qf.acgInformation.service;

import com.qf.acgInformation.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CHAN
 * 2019/12/22 17:29
 */
public interface IMessageService {
    //根据用户id获取所有消息
    List<Message> getMessageByUid(Integer userId);

    //添加消息 / 添加评论
    Integer addMessage(Message message);

    //删除消息 / 删除评论
    Integer deleteMessage(Integer messageId);

    //通过发送者用户 id 以及用户 id 获取所有消息
    List<Message> getMessageByFid(Integer fUserId, Integer userId);

    //通过用户id 获取所有未读消息
    List<Message> getNoReadMessageByUid(Integer userId);

    //通过用户id 获取所有未读消息总数
    Integer getNoReadMessageCountByUid(Integer userId);

    //根据用户id 查看当前发送消息用户的所有未读消息总数
    Integer getThisMessageCount(Integer fUserId, Integer userId);

    //消息更改状态为已读
    void readMessage(Integer fUserId, Integer userId);
}
