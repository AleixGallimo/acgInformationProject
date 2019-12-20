package com.qf.acgInformation.service;

import com.qf.acgInformation.entity.User;

public interface IUserRightService {
    //判断用户是否是VIP
    User isVIP(Integer uid);

    //购买VIP
    Integer BuyVIP(Integer uid);

    //更改用户的权限为VIP
    Integer updateUserRight(Integer uid);
}
