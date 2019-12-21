package com.qf.acgInformation.entity;

import lombok.Data;

/**
 * CHAN
 * 2019/12/21 09:23
 */

@Data
public class Message {
    //索引
    private Integer mId;
    //用户id
    private Integer mUid;
    //评论id
    private Integer mCid;
    //发送方id
    private Integer mFid;
    //内容
    private String mContent;
    //内容类型
    private String mStatus;
    //以读状态
    private Integer isRead;

    //发送方用户资料
    private User user;
}
