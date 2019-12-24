package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.User;

public interface IRewardMapper {

    //查询用户的余额
    User userAccount(Integer uid);

    //根据文章的作者ID查询作者的个人信息
    User findAuthorByAid(Integer aAuthor);

    //用户打赏，余额减少6元
    Integer deductMoney(Integer uid);

    //作者收到打赏，余额增加6元
    Integer addMoney(Integer uid);

    //更新个人信息
    User updateUser(Integer uid);

}
