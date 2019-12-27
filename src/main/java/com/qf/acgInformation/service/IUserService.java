package com.qf.acgInformation.service;

import com.qf.acgInformation.entity.User;

import java.util.List;

public interface IUserService {

    //修改个人信息前的回显
    User findUserById(Integer uid);

    //修改个人资料
    Integer updateUser(User user);

    //显示用户昵称和头像
    User findNameAndPic(Integer uid);

    //注册用户
    Integer addUser(User user);

    //根据account用户名查找ID
    Integer findUserIDByAccount( String account);

    //获得所有用户
    List<User> getAllUser();
}
