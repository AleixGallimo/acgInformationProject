package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.mapper.IRewardMapper;
import com.qf.acgInformation.service.IRewardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class RewardServiceImpl implements IRewardService {
    @Resource
    private IRewardMapper rewardMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public Integer updateMoney(Integer uid,Integer aAuthor) {
        //查询登录用户的余额
        User user = rewardMapper.userAccount(uid);
        Integer uMoney = user.getUMoney();
        //用户的余额大于6元
        if (uMoney>=6){
            //根据文章的作者id查询作者的用户表id
            User author = rewardMapper.findAidByUid(aAuthor);
            Integer aid = author.getUId();
            //用户打赏：余额减少6元
            Integer userAccount = rewardMapper.updateMoney(uid);
            //作者收到打赏：余额增加6元
            Integer authodAccount = rewardMapper.updateMoney2(aid);
            if (authodAccount>0){
                return authodAccount;
            }
            return 0;
        }
        return uMoney;
    }
}
