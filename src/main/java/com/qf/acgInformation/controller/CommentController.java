package com.qf.acgInformation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qf.acgInformation.entity.Comment;
import com.qf.acgInformation.service.ICommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RequestMapping("/comment")
@RestController
public class CommentController {
    @Resource
    private ICommentService commentService;

    @RequestMapping(value = "/check")
    private Integer checkLogin(HttpServletRequest request){
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        Integer adminId = (Integer)request.getSession().getAttribute("adminId");
        if(adminId != null || uid != null){
            return 1;
        }
        return 0;
    }

    /**
     * 获取文章中的评论
     * @param offset        偏移量，起始页为0
     * @param pageSize      每页展示的评论
     * @param articleId     文章id
     * @return              评论集合
     */
    @RequestMapping(value = "/getComment/{offset}/{pageSize}")
    private String getCommentByArticleId(@PathVariable Integer offset, @PathVariable Integer pageSize, Integer articleId){
        List<Comment> list = commentService.getCommentByArticleId(articleId, offset, pageSize);
        //确保集合中的 user 对象不被循环引用
        return JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping(value = "/getCommentDESC/{offset}/{pageSize}")
    private String getCommentByArticleIdDESC(@PathVariable Integer offset, @PathVariable Integer pageSize, Integer articleId){
        List<Comment> list = commentService.getCommentByArticleIdDESC(articleId, offset, pageSize);
        //确保集合中的 user 对象不被循环引用
        return JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 根据用户id获取所有评论
     * @param userId        用户id
     * @return
     */
    @RequestMapping(value = "/getCommentByUid")
    private String getCommentByUserId(Integer userId){
        List<Comment> list = commentService.getCommentByUserId(userId);
        return JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 根据文章id获取文章标题
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/getArticleTitle")
    private String getArticleTitleByAid(Integer articleId){
        return commentService.getArticleTitleById(articleId);
    }

    /**
     * 评论的添加(发送评论)
     * @param comment       评论对象
     * @return              影响行数
     */
    @RequestMapping(value = "/addComment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Integer addComment(@RequestBody Comment comment) {
        Integer integer = commentService.addComment(comment);
        return integer;
    }

    @RequestMapping("/all")
    private Integer getAllCommentCount(Integer articleId){
        return commentService.getAllCommentCountByArticleId(articleId);
    }

    //管理员专用 -- 获取所有评论
    @RequestMapping(value = "/getAllComment/{offset}/{pageSize}")
    private String getAllComment(@PathVariable Integer offset, @PathVariable Integer pageSize){
        List<Comment> list = commentService.getAllComment(offset, pageSize);
//        return JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
    return JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
    }

    //获取所有评论总数
    @RequestMapping(value = "/count")
    private Integer getAllCommentCount(){
        return commentService.getAllCommentCount();
    }

    //删除评论
    @RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    private Integer deleteComment(Integer commentId){
        return commentService.deleteCommentByCommentId(commentId);
    }
}
