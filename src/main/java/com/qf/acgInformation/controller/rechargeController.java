package com.qf.acgInformation.controller;

import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.service.IRechargeService;
import com.qf.acgInformation.service.IRewardService;
import com.qf.acgInformation.service.IUserRightService;
import com.qf.acgInformation.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/rechargeController")
public class rechargeController {

    @Resource
    private IRechargeService rechargeService;
    @Resource
    private IUserService userService;

    @RequestMapping("/recharge")
    public String recharge(String money, String password,HttpServletRequest request){
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        //检查密码
        User user = userService.findUserById(uid);
        //判断输入的密码和数据库的密码是否一致
        if (user.getUPassword().equals(password)){
            Integer money1 = Integer.parseInt(money);
            //充值，用户的余额加上输入的金额
            rechargeService.addMoney(money1,uid);
            //更新用户的信息
            User user1 = userService.findUserById(uid);//要写成自己的MAPPER
            //判断用户的余额是否等于原来的余额加上输入的余额
            if (user1.getUMoney()==user.getUMoney()+money1){
                //相等，返回充值成功
                return "1";
            }
            //充值失败
            return "0";
        }
        //密码不正确
        return "-1";
    }
}
