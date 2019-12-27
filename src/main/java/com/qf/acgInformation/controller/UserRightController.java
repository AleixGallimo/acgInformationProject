package com.qf.acgInformation.controller;


import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.service.IUserRightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/UserRightController")
public class UserRightController {
    @Resource
    private IUserRightService userRightService;

    @RequestMapping(value = "/isVIP", method = RequestMethod.GET)
    public Integer isVIP(HttpServletRequest request) {
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        User isVip = userRightService.isVIP(uid);
        log.debug(String.valueOf("isVip:" + isVip));
        //返回用户的权限
        return isVip.getUAuthority();
    }

    @RequestMapping(value = "/BuyVIP", method = RequestMethod.GET)
    public String BuyVIP(String password1, HttpServletRequest request) {
        log.debug("password1:" + password1);
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        //检查用户的余额是否足够购买VIP
        User user = userRightService.CheckMoney(uid);
        if (user.getUMoney() >= 88.88) {
            //判断输入的密码和注册的密码是否一致
            User user1 = userRightService.checkPassword(uid);
            String password = user1.getUPassword();
            if (password.equals(password1)) {
                //钱和密码都正确就支付
                Integer isVip = userRightService.BuyVIP(uid);
                //判断支付是否成功
                if (isVip > 0) {
                    //支付成功更改用户的权限
                   Integer Vip = userRightService.updateUserRight(uid);
                    log.debug("Vip:" + Vip);
                    //支付成功并用户权限修改成VIP
                    return "1";
                }
            }
            return "2";
        }
        //用户余额不足
        return "0";
    }
}
