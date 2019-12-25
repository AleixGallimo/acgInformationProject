package com.qf.acgInformation.service;

import com.qf.acgInformation.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CHAN
 * 2019/12/19 22:45
 */
public interface ICommentService {
    //通过文章 id 获取所有评论
    List<Comment> getCommentByArticleId(Integer articleId, Integer offset, Integer pageSize);

    //根据评论 id 删除当条评论
    Integer deleteCommentByCommentId(Integer commentId);

    //添加评论
    Integer addComment(@Param("comment") Comment comment);

    //获取文章评论总条数
    Integer getAllCommentCountByArticleId(Integer articleId);

    //获取所有评论总数
    Integer getAllCommentCount();

    //根据用户 id 获取所有评论
    List<Comment> getCommentByUserId(@Param("userId") Integer userId);

    //根据文章 id 获取文章标题
    String getArticleTitleById(@Param("articleId") Integer articleId);

    //管理员专用 -- 获取所有文章评论
    List<Comment> getAllComment(Integer offset, Integer pageSize);
}
