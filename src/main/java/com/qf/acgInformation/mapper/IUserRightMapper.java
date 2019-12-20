package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.User;

public interface IUserRightMapper {
    //判断用户id查询用户权限
    User isVIP(Integer uid);

    //余额减少100元
    Integer BuyVIP(Integer uid);

    //把用户权限改为1
    Integer updateUserRight(Integer uid);

}
