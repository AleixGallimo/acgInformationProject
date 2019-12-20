package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.mapper.IUserMapper;
import com.qf.acgInformation.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserMapper userMapper;
    @Override
    public User findUserById(Integer uid) {
        return userMapper.findUserById(uid);
    }

    @Override
    public void updateUser(User user) {
       userMapper.updateUser(user);
    }

    @Override
    public User findNameAndPic(Integer uid) {
       return userMapper.findNameAndPic(uid);

    }
}
