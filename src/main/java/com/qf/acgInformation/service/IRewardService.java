package com.qf.acgInformation.service;

import com.qf.acgInformation.mapper.IRewardMapper;

import javax.annotation.Resource;

public interface IRewardService {


    //用户打赏功能
    String reward(Integer uid,Integer aAuthor);

}
