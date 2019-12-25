package com.qf.acgInformation.controller;

import com.alibaba.fastjson.JSON;
import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/UserController")
public class UserController {
    @Resource
    private IUserService userService;
    //修改资料前的回显
    @RequestMapping(value = "/findUserById",method = RequestMethod.GET)
    public User findUserById(HttpServletRequest request){
        Object uid = request.getSession().getAttribute("uid");
        User user = userService.findUserById((Integer) uid);
        return user;
    }
    //更新数据
    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public String updateUser(User user, HttpServletRequest request){
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

    //获得单个用户的信息
    @RequestMapping(value = "/findSingleUserById",method = RequestMethod.GET)
    public User findSingleUserById(@RequestParam("id") Integer id){
        User user = userService.findUserById(id);
        return user;
    }

    //注册
    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    public void addUser(@RequestParam("username") String username ,@RequestParam("password") String password ,HttpServletResponse response) throws IOException {
        userService.addUser(new User(username,password));
        response.sendRedirect("/acgInformation/login.html");
    }

    //检查用户名是否存在
    @RequestMapping(value = "/checkAccount")
    public HashMap<String, Boolean> checkAccount(String account){
        HashMap<String, Boolean> map = new HashMap<>();
        if (userService.findUserIDByAccount(account) != 0){
            map.put("valid",false);
            //账号存在
            return map;
        } else {
            map.put("valid", true);
            return map;
        }
    }

    //用户登录
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String userLogin(@RequestParam("uAccount") String uAccount ,@RequestParam("uPassword") String uPassword,HttpServletRequest request){
        Integer uid = userService.findUserIDByAccount(uAccount);
        if (uid!=null){
            User  user = userService.findUserById(uid);
            if (uPassword.equals(user.getUPassword())){
                request.getSession().setAttribute("uid", uid);
            }
        }
        return "登录成功";
    }

    //管理员登录
    @RequestMapping(value = "/adminLogin" ,method = RequestMethod.POST)
    public String adminLogin(@RequestParam("uAccount") String uAccount ,@RequestParam("uPassword") String uPassword,HttpServletRequest request){
        Integer uid = userService.findUserIDByAccount(uAccount);
        if (uid!=null){
            User  user = userService.findUserById(uid);
            if (uPassword.equals(user.getUPassword())&&user.getUAuthority()==3){
                request.getSession().setAttribute("adminId", uid);
                return "登录成功";
            }
        }
        return "登录失败";
    }

    //获取Session中的uid并传到前端
    @RequestMapping("/getSessionId")
    public Object getSessionId(HttpServletRequest request){
        Object uid = request.getSession().getAttribute("uid");
        return uid;
    }

    //登出
    @RequestMapping("/logout")
    public void logOut(HttpServletRequest request , HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("uid");
        response.sendRedirect("/acgInformation/index.html");
    }

    //管理员登出
    @RequestMapping("/adminLogOut")
    public void adminLogOut(HttpServletRequest request , HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("adminId");
        response.sendRedirect("/acgInformation/adminLogin.html");
    }

    //根据传进来的uid查找用户信息
    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    public User findUser(Integer uid){
        log.debug("uid" + uid);
        User ser = userService.findUserById(uid);
        log.debug("用户" + ser);
        return userService.findUserById(uid);
    }

}
