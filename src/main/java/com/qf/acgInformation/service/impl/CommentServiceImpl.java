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
    public List<Comment> getCommentByArticleId(Integer articleId, Integer offset, Integer pageSize) {
        return commentMapper.getCommentByArticleId(articleId, offset, pageSize).isEmpty() ? null : commentMapper.getCommentByArticleId(articleId, offset, pageSize);
    }

    /**
     * 根据评论id删除当条评论
     * @param commentId
     * @return
     */
    @Override
    public Integer deleteCommentByCommentId(Integer commentId) {
        return commentMapper.deleteCommentByCommentId(commentId);
    }

    /**
     * 添加评论
     * @param comment   评论对象
     * @return          影响行数
     */
    @Override
    public Integer addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public Integer getAllCommentCountByArticleId(Integer articleId) {
        return commentMapper.getAllCommentCountByArticleId(articleId);
    }

    /**
     * 管理员专用 -- 获取所有文章评论
     * @return
     */
    @Override
    public List<Comment> getAllComment() {
        return commentMapper.getAllComment().isEmpty() ? null : commentMapper.getAllComment();
    }
}
