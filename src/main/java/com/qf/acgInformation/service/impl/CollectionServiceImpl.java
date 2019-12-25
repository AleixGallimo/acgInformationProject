package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.mapper.ICollectionMapper;
import com.qf.acgInformation.service.ICollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * CHAN
 * 2019/12/24 14:53
 */
@Service
public class CollectionServiceImpl implements ICollectionService {
    @Resource
    private ICollectionMapper collectionMapper;

    @Override
    public Integer getUserIdByArticleId(Integer articleId, String type) {
        return collectionMapper.getUserIdByArticleId(articleId, type);
    }

    @Override
    public Integer addLikeOrMoney(Integer articleId, Integer userId, String type) {
        return collectionMapper.addLikeOrMoney(userId, articleId, type);
    }
}
