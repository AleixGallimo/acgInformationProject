package com.qf.acgInformation.controller;


import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.service.IUserRightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@Slf4j
@RestController
@RequestMapping("/UserRightController")
public class UserRightController {
    @Resource
    private IUserRightService userRightService;

    @RequestMapping("/isVIP")
    public Integer isVIP(HttpServletRequest request){
        request.getSession().setAttribute("uid",1);
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        User isVip = userRightService.isVIP(uid);
        log.debug(String.valueOf("isVip:"+isVip));
        //返回用户的权限
        return isVip.getUAuthority();
    }

    @RequestMapping("/BuyVIP")
    public Integer BuyVIP(HttpServletRequest request) {
        request.getSession().setAttribute("uid",1);
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        Integer isVip = userRightService.BuyVIP(uid);
        Integer Vip = null;
        //判断支付是否成功
        if (isVip > 0) {
            //支付成功更改用户的权限
            Vip = userRightService.updateUserRight(uid);
            log.debug(String.valueOf("Vip:"+Vip));
        }

        return Vip;
    }
}
