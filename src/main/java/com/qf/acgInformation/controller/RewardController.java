package com.qf.acgInformation.controller;

import com.qf.acgInformation.service.IRewardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/RewardController")
public class RewardController {
    @Resource
    private IRewardService rewardService;

//    @RequestMapping("/reward")
//    public String reward(Integer author, HttpServletRequest request){
//        request.getSession().setAttribute("uid",1);
//        Integer uid = (Integer) request.getSession().getAttribute("uid");
//        Integer result = rewardService.updateMoney(uid, author);
//        if (result > 0 && result < 1){
//            //打赏成功
//            return "1";
//        }if (result == 0){
//            //打赏失败
//            return "0";
//        }else if (result < 0)
//        //用户余额不足
//        return "2";
//    }
}
