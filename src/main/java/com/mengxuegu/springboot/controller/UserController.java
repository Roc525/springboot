package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.entities.User;
import com.mengxuegu.springboot.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 用户的控制层
 */
@Controller
public class UserController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public UserMapper userMapper;

    //@RequestMapping(value = "/providers",method = RequestMethod.GET)
    @GetMapping("/users")
    public  String list(Map<String,Object> map ,User user){
        logger.info("用户查询...." + user);

        List<User> users = userMapper.getUsers(null);

        map.put("users",users);
        map.put("username",user.getUsername());
        return "user/list";
    }

    @GetMapping("/searuser/{id}")
    public String view(@PathVariable("id") Integer id,@RequestParam(value = "type",defaultValue ="view") String type, Map<String, Object> map){
        logger.info("查询" + id + "的用户信息");
        User user = userMapper.getUserById(id);
        map.put("user",user);
      //  return  "provider/view";
        return "user/"+ type;
    }

    //修改用户信息
    @PutMapping("/updateuser")
   // @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    public String update(User user){
        logger.info("更新用户信息");
        userMapper.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user")
    public String toAddPage(){
      return "user/add";
    }

    @PostMapping("/adduser")
    public String add(User user){
        logger.info("添加数据" + user);
        userMapper.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/deluser/{id}")
    public String delete(@PathVariable("id") Integer id){
        logger.info("删除操作" + id);
        userMapper.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/user/pwd")
    public  String toUpdatePwdPage(){
        return "main/password";
    }


    @ResponseBody
    @GetMapping("/user/pwds/{oldPwd}")
    public Boolean checkPwd(HttpSession session,@PathVariable("oldPwd") String oldPwd){
        logger.info("旧密码:"+oldPwd);
        User user = (User) session.getAttribute("loginUser");
        if (user.getPassword().equals(oldPwd))
            return  true;
        return  false;
    }

    @RequestMapping(value = "/user/pwd",method = RequestMethod.POST)
    public String updatePwd(HttpSession session,String password){
        User user = (User) session.getAttribute("loginUser");
        user.setPassword(password);
        userMapper.updateUser(user);
        return  "redirect:/loginout";
    }
}
