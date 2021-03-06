package com.qf.acgInformation.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * CHAN
 * 2019/12/24 14:18
 */
public interface ICollectionMapper {
    Integer getUserIdByArticleId(@Param("articleId") Integer articleId, @Param("type") String type);

    Integer addLikeOrMoney(@Param("articleId") Integer articleId, @Param("userId") Integer userId, @Param("type") String type);
}
