package com.qf.acgInformation.controller;

import com.qf.acgInformation.service.IRewardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/reward", method = RequestMethod.GET)
    public String reward(String aAuthor, HttpServletRequest request) {
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        Integer aAuthor1 = Integer.parseInt(aAuthor);
        String result = rewardService.reward(uid, aAuthor1);
        if (result.equals("1")) {
            //打赏成功
            return "1";
        }
        if (result.equals("0")) {
            //打赏失败
            return "0";
        }
        if (result.equals("2")){
            //打赏的用户是同一个人
            return "2";
        }
        //用户余额不足
        return "-1";
    }
}
