package com.baizhi.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true) //用在类上支持set方法的链式调用
//@AllArgsConstructor //用在类上提供全参构造
@Data// 用在类上提供get set tostring noargs hashcode and equals
/*@Getter //用在类上提供get
@Setter //用在类上提供set
@NoArgsConstructor
@ToString
@EqualsAndHashCode*/
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;

   /* public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }*/
}
