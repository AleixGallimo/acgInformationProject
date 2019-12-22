package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.User;

import java.util.List;

public interface IUserMapper {
    //根据id查找user
    User findUserById(Integer uid);

    //修改个人资料
    Integer updateUser(User user);

    //根据id查询自己的昵称和头像
    User findNameAndPic(Integer uid);

}
