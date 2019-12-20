package com.qf.acgInformation.service;

import com.qf.acgInformation.entity.User;

import java.util.List;

public interface IUserService {

    //修改个人信息前的回显
    User findUserById(Integer uid);

    //修改个人资料
    void updateUser(User user);

    //显示用户昵称和头像
    User findNameAndPic(Integer uid);
}
