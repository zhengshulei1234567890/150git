package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public List<User> queryAll();

    public User queryUserByNameAndPass(@Param("name") String name, @Param("password") String password);

    public void deleteByName(String name);

    public void addUser(User user);

    public  List<User> queryUserLike(String username);

    public User queryByName(String username);

    public  void update(User user);

    public void register(User user);

    public List<User> queryAllNyPage(Integer count);
}
