package com.qf.acgInformation.service;

import org.apache.ibatis.annotations.Param;

/**
 * CHAN
 * 2019/12/24 14:29
 */
public interface ICollectionService {
    Integer getUserIdByArticleId(Integer articleId, String type);

    Integer addLikeOrMoney(Integer articleId, Integer userId, String type);
}
