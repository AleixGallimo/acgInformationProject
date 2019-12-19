package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.User;

import java.util.List;

public interface IUserMapper {
    //根据id查找user
    List<User> findUserById(Integer id);
}
