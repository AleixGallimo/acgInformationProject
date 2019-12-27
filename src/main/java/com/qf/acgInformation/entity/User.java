package com.qf.acgInformation.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息实体类
 * CHAN
 * 2019/12/19 16:59
 */
@Data
public class User {
    //用户id
    private Integer uId;
    //账号
    private String uAccount;
    //密码
    private String uPassword;
    //昵称
    private String uName;
    //头像
    private String uPic;
    //电子邮箱
    private String uEmail;
    //生日
    private String uBirth;
    //性别
    private String uSex;
    //简介
    private String uBrief;
    //余额
    private Integer uMoney;
    //用户权限（0禁言，1默认普通用户，2vip用户，3管理员）
    private Integer uAuthority;
    //用户关注列表
    private List<User> users;

    public User() {
    }

    public User(String uAccount, String uPassword, String uName) {
        this.uAccount = uAccount;
        this.uPassword = uPassword;
        this.uName = uName;
    }
}
