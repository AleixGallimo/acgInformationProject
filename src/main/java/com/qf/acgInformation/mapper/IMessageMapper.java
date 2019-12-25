package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CHAN
 * 2019/12/21 14:08
 */
public interface IMessageMapper {

    //通过单条评论 id 获取所有子评论
    List<Message> getMessageByCid(@Param("commentId") Integer commentId);

    //通过用户id获取所有消息
    List<Message> getMessageByUid(@Param("userId") Integer userId);

    //通过用户id 获取所有未读消息
    List<Message> getNoReadMessageByUid(@Param("userId") Integer userId);

    //通过用户id 获取所有未读消息总数
    Integer getNoReadMessageCountByUid(@Param("userId") Integer userId);

    //通过发送者用户 id 以及用户 id 获取所有消息
    List<Message> getMessageByFid(@Param("fUserId") Integer fUserId, @Param("userId") Integer userId);

    //添加消息
    Integer addMessage(@Param("message") Message message);

    //删除消息
    Integer deleteMessage(@Param("messageId") Integer messageId);

    //根据用户id 查看当前发送消息用户的所有未读消息总数
    Integer getThisMessageCount(@Param("fUserId") Integer fUserId, @Param("userId") Integer userId);

    //消息更改状态为已读
    void readMessage(@Param("fUserId") Integer fUserId, @Param("userId") Integer userId);
}
