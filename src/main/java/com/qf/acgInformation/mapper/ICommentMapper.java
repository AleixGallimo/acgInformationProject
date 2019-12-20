package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CHAN
 * 2019/12/19 22:33
 */
public interface ICommentMapper {
    //通过 articleId 获取评论
    List<Comment> getCommentByArticleId(@Param("articleId") Integer articleId, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    //添加评论
    Integer addComment(@Param("comment") Comment comment);

    //删除单条评论
    Integer deleteCommentByCommentId(@Param("commentId") Integer commentId);

    //管理员专用 -- 获取所有文章评论
    List<Comment> getAllComment();
}

