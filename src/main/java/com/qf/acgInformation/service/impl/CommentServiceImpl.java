package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.entity.Comment;
import com.qf.acgInformation.mapper.ICommentMapper;
import com.qf.acgInformation.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * CHAN
 * 2019/12/19 22:47
 */
@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    private ICommentMapper commentMapper;

    /**
     * 获取单篇文章所有评论
     * @param articleId     文章id
     * @return              评论集合
     */
    @Override
    public List<Comment> getCommentByArticleId(Integer articleId) {
        return commentMapper.getCommentByArticleId(articleId);
    }
}
