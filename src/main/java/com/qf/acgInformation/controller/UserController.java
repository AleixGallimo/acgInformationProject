package com.qf.acgInformation.controller;

import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.UUID;

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
        if (user.getUAccount()!=null && user.getUPassword()!=null){
        user1 = user;
        log.debug("user1:"+user1);
            Integer updateUser = userService.updateUser(user1);
            if (updateUser>0){
                return "1";
            }
        }else {
            return "-1";
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



    //上传头像
    @RequestMapping(value = "/fileDownLoad",method = RequestMethod.POST)
    public void fileDownLoad(HttpServletRequest request,HttpServletResponse response,String fileName,String fileType) throws IOException {
        //读取服务器中的文件
        String realPath = request.getSession().getServletContext().getRealPath("images");

        File file = new File(realPath+"/"+fileName);

        //设置文件的长度
        response.setContentLength((int) file.length());
        //设置文件的类型
        response.setContentType(fileType);

        //解决下载文件的中文名乱码问题
        String userAgent = request.getHeader("user-agent");
        if (userAgent.contains("MSIE")) {
            // IE浏览器
            fileName = URLEncoder.encode(fileName, "utf-8");
            fileName = fileName.replace("+", " ");
        } else if (userAgent.contains("Firefox")) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            fileName = "=?utf-8?B?" + base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            fileName = URLEncoder.encode(fileName, "utf-8");
        }


        //设置响应头，Content-Disposition 通知客户端已下载的方式接受数据
        response.setHeader("Content-Disposition","attachment;filename="+fileName);

        //获取文件输入流
        FileInputStream input = new FileInputStream(file);
        //获取文件输入流
        OutputStream output = response.getOutputStream();

        IOUtils.copy(input,output);
        output.close();
        input.close();

    }



    //把图片的url存入数据库
//    public void insertUrl(String url){
//
//
//    }


}

