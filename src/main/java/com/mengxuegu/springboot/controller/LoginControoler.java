package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.entities.User;
import com.mengxuegu.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginControoler {

    @Autowired
    public UserMapper userMapper;

    @PostMapping("/login")
    public String login(HttpSession session, String username, String password, Map<String,Object> map){

        User user = userMapper.loginUser(new User(username, password));
        if(user != null){
            session.setAttribute("loginUser",user);
            //登录成功
            //重定向:redirect 可以重定向到任意一个请求，地址栏改变
            return "redirect:/main.html";
        }
        //登录失败
        map.put("msg","用户名或密码错误!");
      return "main/login";
    }

    //退出登录
    @GetMapping("/loginout")
    public String loginout(HttpSession session){
        //清空session中的用户
        session.removeAttribute("loginUser");
        session.invalidate();
        //返回登录页
        return "redirect:/index.html";
    }
}
