package com.qf.acgInformation.controller;

import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@Slf4j
@RestController
@RequestMapping("/UserController")
public class UserController {
    @Resource
    private IUserService userService;
    //修改资料前的回显
    @RequestMapping("/findUserById")
    public User findUserById(HttpServletRequest request){
        request.getSession().setAttribute("uid",1);
        Object uid = request.getSession().getAttribute("uid");
        User user = userService.findUserById((Integer) uid);
        return user;
    }
    //更新数据
    @RequestMapping("/updateUser")
    public User updateUser(User user,HttpServletRequest request){
        userService.updateUser(user);
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        return userService.findUserById(uid);
    }

    //显示用户的昵称和头像
    @RequestMapping("/findNameAndPic")
    public User findNameAndPic(HttpServletRequest request){
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        return userService.findNameAndPic(uid);
    }

}
