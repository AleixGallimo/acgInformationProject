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

    /**
     * 删除消息 / 删除子评论
     * @param messageId
     * @return
     */
    @Override
    public Integer deleteMessage(Integer messageId) {
        return messageMapper.deleteMessage(messageId);
    }

    @Override
    public List<Message> getMessageByFid(Integer fUserId, Integer userId) {
        return messageMapper.getMessageByFid(fUserId, userId);
    }
}
