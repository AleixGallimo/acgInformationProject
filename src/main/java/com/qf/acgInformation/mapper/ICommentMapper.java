package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CHAN
 * 2019/12/19 22:33
 */
public interface ICommentMapper {
    //通过文章 id 获取所有评论
    List<Comment> getCommentByArticleId(@Param("articleId") Integer articleId);
}
