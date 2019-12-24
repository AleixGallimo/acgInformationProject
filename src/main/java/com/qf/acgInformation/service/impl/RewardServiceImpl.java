package com.qf.acgInformation.service.impl;

import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.mapper.IRewardMapper;
import com.qf.acgInformation.service.IRewardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class RewardServiceImpl implements IRewardService {
    @Resource
    private IRewardMapper rewardMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String reward(Integer uid, Integer aAuthor) {
        //查询登录用户的余额
        User user = rewardMapper.userAccount(uid);
        Integer uMoney = user.getUMoney();
        //用户的余额大于6元
        if (uMoney >= 6) {
            //根据文章的作者id查询作者的个人信息
            User author = rewardMapper.findAuthorByAid(aAuthor);
            //拿到作者的余额
            Integer authorMoney = author.getUMoney();
            //如果用户和作者不是同一个人，可以打赏
            if (!uid.equals(aAuthor)) {
                //用户的余额减少6元
                Integer userResult = rewardMapper.deductMoney(uid);
                //作者的余额增加6元
                Integer authorResult = rewardMapper.addMoney(author.getUId());
                //更新作者的个人信息
                User newAuthor = rewardMapper.updateUser(aAuthor);
                //更新用户的个人信息
                User newUser = rewardMapper.updateUser(uid);
                log.debug("newAuthor.getUMoney():" + newAuthor.getUMoney());
                log.debug("newUser.getUMoney():" + newUser.getUMoney());
                if (newAuthor.getUMoney() == authorMoney + 6 && newUser.getUMoney() == uMoney - 6) {
                    //打赏成功
                    return "1";
                }
                //打赏失败
                return "0";
            }
            //打赏的是同一个人
            return "2";
        }
        //用户余额不足
        return "-1";
    }
}

