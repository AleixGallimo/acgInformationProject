package com.qf.acgInformation.controller;

import com.qf.acgInformation.entity.Comment;
import com.qf.acgInformation.service.ICommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * CHAN
 * 2019/12/19 22:51
 */
@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private ICommentService commentService;

    @RequestMapping(value = "/getComment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private List<Comment> getCommentByArticleId(Integer articleId){
        List<Comment> commentList = commentService.getCommentByArticleId(articleId);
        return commentList.isEmpty() ? null : commentList;
    }
}
