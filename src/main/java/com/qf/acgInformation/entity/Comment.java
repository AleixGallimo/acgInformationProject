package com.qf.acgInformation.entity;

import lombok.Data;

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
}
