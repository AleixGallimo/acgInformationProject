package com.qf.acgInformation.Controller;

import com.qf.acgInformation.entity.User;
import com.qf.acgInformation.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/UserController")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/findUserById")
    public List<User> findUserById(HttpServletRequest request){
        request.getSession().setAttribute("uid",1);
        Object uid = request.getSession().getAttribute("uid");
        List<User> user = userService.findUserById((Integer) uid);
        return user;
    }
}
