package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserMapper {
    //根据id查找user
    User findUserById(Integer uid);

    //修改个人资料
    Integer updateUser(User user);

    //根据id查询自己的昵称和头像
    User findNameAndPic(Integer uid);

    //注册用户
    Integer addUser(User user);

    //根据account用户名查找ID
    Integer findUserIDByAccount(@Param("account") String account);

}
