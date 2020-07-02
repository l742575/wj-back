package com.ida.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lh
 * @date 2020/5/8
 * @description
 */
@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
