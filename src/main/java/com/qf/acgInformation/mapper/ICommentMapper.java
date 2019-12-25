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

    //获取文章评论总条数
    Integer getAllCommentCountByArticleId(@Param("articleId") Integer articleId);

    //根据用户 id 获取所有评论
    List<Comment> getCommentByUserId(@Param("userId") Integer userId);

    //根据文章 id 获取文章标题
    String getArticleTitleById(@Param("articleId") Integer articleId);

    //管理员专用 -- 获取所有文章评论
    List<Comment> getAllComment(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    //管理员专用 -- 还原删除评论
    void restoreComment(@Param("commentId") Integer commentId);

    //管理员专用 -- 查看所有已删除评论
    List<Comment> getDeleteComment(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    //管理员 -- 获取所有评论总数
    Integer getAllCommentCount();
}

