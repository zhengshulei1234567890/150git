package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    public List<User> queryAll();

    public User queryUserByNameAndpassword(String name,String password);

    public void deleteByName(String name);

    public void addUser(User user);

    public List<User> findByNameLike(String username);

    public User findByName(String username);

    public void updateStatus(User user);

    public void register(User user);

    public List<User> findUserByPage(Integer count);
}
