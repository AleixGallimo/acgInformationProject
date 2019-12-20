package com.qf.acgInformation.service;

import com.qf.acgInformation.entity.User;

import java.util.List;

public interface IUserService {

    //修改个人信息前的回显
    List<User> findUserById(Integer uid);
}
