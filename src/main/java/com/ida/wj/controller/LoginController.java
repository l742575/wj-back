package com.ida.wj.controller;

import com.ida.wj.common.Result;
import com.ida.wj.pojo.User;
import com.ida.wj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lh
 * @date 2020/5/8
 * @description
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

   /* @CrossOrigin
    @RequestMapping(value ="/api/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User user) {
        Result result = new Result();
        String username = user.getUsername();
        String password = user.getPassword();
        if (!username.isEmpty() || !password.isEmpty()) {
            //根据用户名和密码查询用户
            User users = userService.findUser(username, password);
            if (users != null) {
                result.setCode(200);

            } else {
                result.setCode(1001);
                result.setMessage("用户名或密码错误！");
            }
        }
        return result;
    }*/
    @CrossOrigin
    @RequestMapping(value ="/api/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User user) {
        Result result = new Result();
        String username = user.getUsername();
        String password = user.getPassword();
        //认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
            result.setCode(200);
            result.setMessage("成功");
        }catch (AuthenticationException e)  {
            result.setCode(1001);
            result.setMessage("用户名或密码错误");

        }
        return result;
    }
    @CrossOrigin
    @RequestMapping(value = "/api/register",method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();
        if (!username.equals("") && !password.equals("")){
            //判断用户名是否存在
             String exist = userService.isExistUsername(username);
             if(exist!=null){
                 return new Result(1001,"该用户名已注册！");
             }
            /**
             * 密码加密
             * 1、设置盐值
             * 2、加密->得到加密后的密码
             * 3、保存
             */
             String salt = new SecureRandomNumberGenerator().nextBytes().toString();
             String encodedPassword = new SimpleHash("md5",password,salt,2).toHex();
             user.setPassword(encodedPassword);
             user.setSalt(salt);
             userService.save(user);
                return new Result(200,"恭喜注册成功，请登录！");
            }else{
                return new Result(1002,"用户名密码不能为空");
            }

    }
}

