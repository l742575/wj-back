package com.ida.wj.service;

import com.ida.wj.dao.UserDao;
import com.ida.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lh
 * @date 2020/5/12
 * @description
 */
@Service
public class UserService  {
    @Autowired
    private UserDao userDao;

    public User findUser(String username,String password){
        return userDao.findUserByUsernameAndPassword(username,password);
    }

    /**
     * 判断用户名是否存在
     * @return
     */
    public String isExistUsername(String username){
        return  userDao.exists(username);

    }

    /**
     * 保存用户
     * @param user
     */
    public void save(User user){
         userDao.save(user);
    }
    public User findUserByUsername(String username){
        return userDao.findUserByUsername(username);
    }
}
