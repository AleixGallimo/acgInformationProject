package com.qf.acgInformation.service;

import com.qf.acgInformation.entity.Comment;

import java.util.List;

/**
 * CHAN
 * 2019/12/19 22:45
 */
public interface ICommentService {
    //通过文章 id 获取所有评论
    List<Comment> getCommentByArticleId(Integer articleId);
}
