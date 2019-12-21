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
}
