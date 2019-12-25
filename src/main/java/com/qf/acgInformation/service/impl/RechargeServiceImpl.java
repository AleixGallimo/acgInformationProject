package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.mapper.IRechargeMapper;
import com.qf.acgInformation.service.IRechargeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class RechargeServiceImpl implements IRechargeService {
    @Resource
    private IRechargeMapper rechargeMapper;
    @Override
    public void addMoney(Integer money,Integer uid) {
        rechargeMapper.addMoney(money,uid);
    }

//    @Override
//    public User updateUser1(Integer uid) {
//        return rechargeMapper.updateUser1(uid);
//    }
}
