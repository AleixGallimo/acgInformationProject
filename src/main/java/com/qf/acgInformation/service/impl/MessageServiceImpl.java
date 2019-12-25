package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.entity.Message;
import com.qf.acgInformation.mapper.IMessageMapper;
import com.qf.acgInformation.service.IMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * CHAN
 * 2019/12/22 17:30
 */
@Service
public class MessageServiceImpl implements IMessageService {
    @Resource
    private IMessageMapper messageMapper;

    /**
     * 根据用户id 获取所有消息
     * @param userId
     * @return
     */
    @Override
    public List<Message> getMessageByUid(Integer userId) {
        return messageMapper.getMessageByUid(userId);
    }

    @Override
    public Integer addMessage(Message message) {
        return messageMapper.addMessage(message);
    }

    //删除消息 / 删除子评论
    @Override
    public Integer deleteMessage(Integer messageId) {
        return messageMapper.deleteMessage(messageId);
    }

    //根据他 id 获取回复消息
    @Override
    public List<Message> getMessageByFid(Integer fUserId, Integer userId) {
        return messageMapper.getMessageByFid(fUserId, userId);
    }

    //通过用户id 获取所有未读消息
    @Override
    public List<Message> getNoReadMessageByUid(Integer userId) {
        return messageMapper.getNoReadMessageByUid(userId);
    }

    //通过用户id 获取所有未读消息总数
    @Override
    public Integer getNoReadMessageCountByUid(Integer userId) {
        return messageMapper.getNoReadMessageCountByUid(userId);
    }

    //获取他回复用户消息未读总数
    @Override
    public Integer getThisMessageCount(Integer fUserId, Integer userId) {
        return messageMapper.getThisMessageCount(fUserId, userId);
    }

    //更改消息状态为已读
    @Override
    public void readMessage(Integer fUserId, Integer userId) {
        messageMapper.readMessage(fUserId, userId);
    }
}
