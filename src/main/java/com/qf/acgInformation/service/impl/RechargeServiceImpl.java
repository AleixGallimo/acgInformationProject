package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.service.IRechargeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RechargeServiceImpl implements IRechargeService {
    @Resource
    private IRechargeService rechargeService;
    @Override
    public void addMoney(Integer money, Integer uid) {
        rechargeService.addMoney(money,uid);
    }
}
