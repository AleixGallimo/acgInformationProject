package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CHAN
 * 2019/12/21 14:08
 */
public interface IMessageMapper {
    /**
     * 通过单条评论 id 获取所有子评论
     * @param commentId
     * @return
     */
    List<Message> getMessageByCid(@Param("commentId") Integer commentId);

    //通过用户id获取所有消息
    List<Message> getMessageByUid(@Param("userId") Integer userId);

    //通过发送者用户 id 以及用户 id 获取所有消息
    List<Message> getMessageByFid(@Param("fUserId") Integer fUserId, @Param("userId") Integer userId);

    //添加消息
    Integer addMessage(@Param("message") Message message);

    //删除消息
    Integer deleteMessage(@Param("messageId") Integer messageId);
}
