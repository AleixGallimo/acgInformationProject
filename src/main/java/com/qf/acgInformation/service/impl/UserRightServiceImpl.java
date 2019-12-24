package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.mapper.IUserRightMapper;
import com.qf.acgInformation.service.IUserRightService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRightServiceImpl implements IUserRightService {

    @Resource
    private IUserRightMapper userRightMapper;

    @Override
    public User isVIP(Integer uid) {
        return userRightMapper.isVIP(uid);
    }

    @Override
    public User CheckMoney(Integer uid) {
       return userRightMapper.CheckMoney(uid);
    }

    @Override
    public Integer BuyVIP(Integer uid) {
        return  userRightMapper.BuyVIP(uid);
    }

    @Override
    public User checkPassword(Integer uid) {
       return userRightMapper.checkPassword(uid);
    }

    @Override
    public Integer updateUserRight(Integer uid) {
        return userRightMapper.updateUserRight(uid);
    }


}
