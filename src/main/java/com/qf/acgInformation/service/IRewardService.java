package com.qf.acgInformation.service;

import com.qf.acgInformation.mapper.IRewardMapper;

import javax.annotation.Resource;

public interface IRewardService {


    //用户打赏的余额减少6元
    Integer updateMoney(Integer uid,Integer aAuthor);

}
