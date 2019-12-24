package com.qf.acgInformation.entity;

import lombok.Data;

import java.util.List;


/**
 * 评论实体类
 * CHAN
 * 2019/12/19 17:24
 */
@Data
public class Comment {
    private Integer cId;
    private String cText;
    private String cPic;
    private Integer cUid;
    private Integer cAid;
    //当前评论的用户信息
    private User user;
    //当前评论的所有子评论
    private List<Message> messages;
}
