package com.qf.acgInformation.controller;

import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/UserController")
public class UserController {
    @Resource
    private IUserService userService;

    //检查用户登录状态
    @RequestMapping(value = "/check")
    private Integer checkLogin(HttpServletRequest request){
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        Integer adminId = (Integer)request.getSession().getAttribute("adminId");
        if(adminId != null || uid != null){
            return 1;
        }
        return 0;
    }

    //修改资料前的回显
    @RequestMapping(value = "/findUserById",method = RequestMethod.GET)
    public User findUserById(HttpServletRequest request){
        Object uid = request.getSession().getAttribute("uid");
        User user = userService.findUserById((Integer) uid);
        return user;
    }

    //修改用户资料
    @RequestMapping(value = "/modified", method = RequestMethod.POST)
    private Integer modified(@RequestBody User user){
        return userService.updateUser(user);
    }
    //修改用户头像
    @RequestMapping(value = "/modifiedPic", method = RequestMethod.POST)
    private String modifiedPic(@RequestParam(value = "file", required = false) MultipartFile upload, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/asserts/images/headPicture");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        //解决重名问题
        //获取文件名
        String filename = upload.getOriginalFilename();
        //拼接UUID
        filename = UUID.randomUUID().toString()+"_"+filename;
        //调用 MultipartFile 的 transferTo() 完成文件上传
        upload.transferTo(new File(file,filename));
        return filename;
    }

    //更新数据
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public Integer updateUser(@RequestBody User user, HttpServletRequest request){
        Object uid = request.getSession().getAttribute("uid");
        user.setUId((Integer) uid);
        return userService.updateUser(user);

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
    @RequestMapping(value = "/register")
    public Integer addUser(String username, String password) {
        Random random = new Random();

        Integer integer = userService.addUser(new User(username, password, "用户" + random.nextInt(999999) + 1));

        return integer;
    }

    //检查用户名是否存在
    @RequestMapping(value = "/checkAccount")
    public HashMap<String, Boolean> checkAccount(String account){
        HashMap<String, Boolean> map = new HashMap<>();
        try {
            if (userService.findUserIDByAccount(account) != 0){
                map.put("valid",false);
                //账号存在
                return map;
            }
        } catch (Exception e){
            map.put("valid", true);
            return map;
        }
        return null;
    }

    //用户登录
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String userLogin(@RequestParam("uAccount") String uAccount ,@RequestParam("uPassword") String uPassword,HttpServletRequest request){
        Integer uid = userService.findUserIDByAccount(uAccount);
        if (uid == null){
            return "false";
        }
        User  user = userService.findUserById(uid);
        if (uPassword.equals(user.getUPassword())){
            request.getSession().setAttribute("uid", uid);
            return "true";
        }
        return "false";
    }

    //管理员登录
    @RequestMapping(value = "/adminLogin" ,method = RequestMethod.POST)
    public String adminLogin(@RequestParam("uAccount") String uAccount ,@RequestParam("uPassword") String uPassword,HttpServletRequest request){
        Integer uid = userService.findUserIDByAccount(uAccount);
        if (uid != null){
            User user = userService.findUserById(uid);
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

    //获得所有用户
    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){
        List<User> list = userService.getAllUser();
        return list;
    }

}
