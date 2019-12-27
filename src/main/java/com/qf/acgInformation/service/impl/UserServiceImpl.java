package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.mapper.IUserMapper;
import com.qf.acgInformation.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserMapper userMapper;
    @Override
    public User findUserById(Integer uid) {
        return userMapper.findUserById(uid);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User findNameAndPic(Integer uid) {
       return userMapper.findNameAndPic(uid);

    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer findUserIDByAccount(String account) {
        return userMapper.findUserIDByAccount(account);
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }
}
