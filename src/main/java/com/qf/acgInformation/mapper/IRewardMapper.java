package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.User;

public interface IRewardMapper {

    //查询用户的余额
    User userAccount(Integer uid);

    //根据文章的作者ID查询用户表的id
    User findAidByUid(Integer aAuthor);

    //用户的余额减少6元
    Integer updateMoney(Integer uid);

    //作者收到打赏的金额增加6元
    Integer updateMoney2(Integer aid);
}
