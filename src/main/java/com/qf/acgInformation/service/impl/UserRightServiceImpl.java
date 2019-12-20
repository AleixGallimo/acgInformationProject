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
    public Integer BuyVIP(Integer uid) {
        return  userRightMapper.BuyVIP(uid);
    }

    @Override
    public Integer updateUserRight(Integer uid) {
        return userRightMapper.updateUserRight(uid);
    }


}
