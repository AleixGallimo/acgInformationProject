package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.entity.Message;
import com.qf.acgInformation.mapper.IMessageMapper;
import com.qf.acgInformation.service.IMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * CHAN
 * 2019/12/22 17:30
 */
@Service
public class MessageServiceImpl implements IMessageService {
    @Resource
    private IMessageMapper messageMapper;

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
}
