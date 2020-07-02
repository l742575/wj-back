package com.ida.wj.dao;

import com.ida.wj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author lh
 * @date 2020/5/12
 * @description
 */
public interface UserDao extends JpaRepository<User,Integer> {
    public User findUserByUsernameAndPassword(String username,String password);

    @Query("select username from User u where username = ?1")
    public String exists(String username);

    /**
     * 通过用户名查用户，用户名不重复
     * @param username
     * @return
     */
    public User findUserByUsername(String username);

}
