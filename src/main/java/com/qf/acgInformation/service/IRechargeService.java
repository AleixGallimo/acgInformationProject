package com.qf.acgInformation.service;

import com.qf.acgInformation.entity.User;

public interface IRechargeService {
    //充值相应的金额
    void addMoney(Integer money,Integer uid);

    //根据用户id更新用户信息
//    User updateUser1(Integer uid);
}
