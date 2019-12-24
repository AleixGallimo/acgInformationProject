package com.qf.acgInformation.controller;

import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@Slf4j
@RestController
@RequestMapping("/UserController")
public class UserController {
    @Resource
    private IUserService userService;
    //修改资料前的回显
    @RequestMapping(value = "/findUserById",method = RequestMethod.GET)
    public User findUserById(HttpServletRequest request){
        request.getSession().setAttribute("uid",1);
        Object uid = request.getSession().getAttribute("uid");
        User user = userService.findUserById((Integer) uid);
        return user;
    }
    //更新数据
    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public String updateUser(User user, HttpServletRequest request){
        request.getSession().setAttribute("uid",1);
        Object uid = request.getSession().getAttribute("uid");
        log.debug("uid:"+uid);
        user.setUId((Integer) uid);
        User user1 = userService.findUserById((Integer) uid);
        log.debug("user1:"+user1);
        log.debug("user:"+user);
//        String uAccount = user1.getUAccount();
        user1 = user;
        log.debug("user1:"+user1);
        Integer updateUser = userService.updateUser(user1);
        if (updateUser>0){
            return "1";
        }
        return "0";

    }

    //显示用户的昵称和头像
    @RequestMapping(value = "/findNameAndPic",method = RequestMethod.GET)
    public User findNameAndPic(HttpServletRequest request){
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        return userService.findNameAndPic(uid);
    }


    //根据传进来的uid查找用户信息
    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    public User findUser(Integer uid){
        return userService.findUserById(uid);
    }
}
